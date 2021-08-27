class Person {

  /**

  */
  constructor(w, t) {
    this.w = w;
    this.t = t;
    this.sayText = ``;
    this.saidText = ``;
    this.sayTextLines = 1;
    this.lineHeight = textAscent() + textDescent + 2;
    this.charWidth = 10;
    this.LINE_LENGTH = 15;
    this.sayAlpha = 220;
  }

  /**

  */
  display() {
    let b1, b2, b3 = 0;
    let str = ``;
    for (let i = 0; i < this.sayText.length; i++) {
      if (b1 > b3) {
        b3 = b1;
      }
      if (this.sayText[i] === ` ` && b1 >= this.LINE_LENGTH) {
        str = str + this.sayText.substring(i - b1, i) + `\n`;
        b1 = 0;
        b2++;
      }
      b1++;
    }
    str = str + this.sayText.substring(this.sayText.length - b1, this.sayText.length);
    if (str.length > 0) {
      this.drawBalloon(str, (b3 + 1), (b2 + 2));
    }
  }

  /**

  */
  drawBalloon(str, p1, p2) {
    let x = this.w.getX(this.t);
    let y = this.w.getY(this.t);

    push();
    fill(255, this.sayAlpha);
    stroke(200, this.sayAlpha);
    beginShape();
    vertex(x, y - 20);
    vertex(x, y - 80);
    vertex(x - p1 * this.charWidth / 2 - 5, y - 80);
    vertex(x - p1 * this.charWidth / 2 - 5, y - 80 - p2 * this.lineHeight);
    vertex(x + p1 * this.charWidth / 2 + 5, y - 80 - p2 * this.lineHeight);
    vertex(x + p1 * this.charWidth / 2 + 5, y - 80);
    vertex(x + 5, y - 80);
    vertex(x, y - 20);
    endShape();
    pop();

    push()
    fill(50, this.sayAlpha);
    textFont(`Courier`);
    textAlign(CENTER, CENTER); // ???
    text(str.toUpperCase(), x, y - 80 - (p1 - 1) * this.lineHeight + this.lineHeight / 2);
  }

  /**

  */
  said() {
    if (this.saidText.length < 0) {
      const str = this.saidText;
      this.saidText = ``;
      return str;
    } else {
      return ``;
    }
  }

  // GETTERS WERE HERE BUT FUCK IT
  getT() {
    return this.t;
  }

  getX() {
    return this.w.getX(this.t);
  }

  getY() {
    return this.w.getY(this.t);
  }

}