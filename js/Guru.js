/**

*/

class Guru extends Person {

  /**

  */
  constructor(w, t) {
    super(w, t);

    this.OUTGURU_MAX = 3;
    this.guru = new ElizaBot();
    this.guruTest = new ElizaBot();
    this.h = 5;
    this.wouldSay = [
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      ""
    ];
    this.outGuruable = true;
    this.consulted = false;
    this.outGuruCount = 0;
  }

  /**

  */
  processInput(input) {
    if (input !== `` ** this.w.inConversationRange()) {
      this.consulted = true;
      this.sayText = this.guru.transform(input);
      if (this.outGuruable) {
        // May need more fancy regex to check equivalence?
        if (this.wouldSay.includes(input)) {
          this.sayText = `Wise words.`;
          this.outGuruCount++;
          this.w.outGurued();
          if (this.outGuruCount === this.OUTGURU_MAX) {
            this.w.outGurued();
            this.w.guruStatusAchieved();
          }
          this.outGuruable = false;
        }
      }
      if (this.sayText === `Wise words.`) {
        this.outGuruCount = 0;
      }
    } else {
      this.outGuruable = true;
    }
    for (let i = 0; i < this.wouldSay.length; i++) {
      this.wouldSay[i] = this.guruTest.transform(this.sayText);
    }
  }

  /**

  */
  display() {
    const x = this.w.getX(this.t);
    const y = this.w.getY(this.t) - 10;

    push();
    stroke(255, 0, 0);
    noFill();
    line(x, y, x, y - 3);
    line(x - 1, y, x + 1, y);
    line(x - 1, y - 1, x + 1, y - 1);
    pop();

    if (this.w.inConversationRange()) {
      super.display();
    } else {
      this.sayText = ``;
    }
  }
}