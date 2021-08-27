class Avatar extends Person {


  constructor(param1World, param1Int) {

    super(param1World, param1Int);
    this.sayableString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ !@#$%^&*()_-+=1234567890?/,.'\";:][{}";
    this.walkCyclePosition = 0;

    this.avatarColour = color(0, 0, 0);
    this.meditating = false;
    this.walking = false;
    this.atHome = true;
    this.guruStatus = false;
    this.h = 5;
  }

  display() {
    if (this.atHome) {
      return;
    }

    let i = this.w.getX(this.t) - 1;
    let j = this.w.getY(this.t) - 1;

    push();
    stroke(this.avatarColour);

    if (!this.meditating && !this.guruStatus) {
      if (!this.walking) {
        line(i, (j - 2), i, (j - this.h));
        line((i - 1), j, (i - 1), (j - 1));
        line((i + 1), j, (i + 1), (j - 1));
        line((i - 1), (j - 3), (i + 1), (j - 3));
      } else if (this.walking) {
        if (this.walkCyclePosition == 0) {
          line(i, (j - 1), i, (j - this.h));
          point((i - 1), (j - 1));
          point((i + 1), j);
        } else if (this.walkCyclePosition == 1) {
          line(i, (j - 1), i, (j - this.h));
          point((i - 1), j);
          point((i + 1), (j - 1));
        }
        if (frameCount % 5 == 0) {
          this.walkCyclePosition = 1 - this.walkCyclePosition;
        }
      }
    } else if (this.guruStatus) {
      i = this.w.getX(this.t);
      j = this.w.getY(this.t) - 10;
      stroke(255.0, 0.0, 0.0);
      line(i, j, i, (j - 3));
      line((i - 1), j, (i + 1), j);
      line((i - 1), (j - 1), (i + 1), (j - 1));
    } else {
      line(i, j, i, (j - 3));
      line((i - 1), j, (i + 1), j);
      line((i - 1), (j - 1), (i + 1), (j - 1));
    }
    super.display();
  }

  becomeGuru(param1Int) {
    this.t = param1Int;
    this.guruStatus = true;
    this.avatarColour = color(255, 0, 0);
  }


  guruStatus() {
    return this.guruStatus;
  }

  keyPressed() {

  }

  handleInput() {
    if (!this.atHome && !this.meditating && !this.guruStatus) {
      this.handleMovementInput();
      this.handleSpeechInput();
    }
  }

  handleMovementInput() {
    if (keyIsDown(37)) {
      this.t -= 10;
      this.w.avatarMoved(this.t, -10);
    } else if (keyIsDown(39)) {
      this.t += 10;
      this.w.avatarMoved(this.t, 10);
    }
  }

  handleSpeechInput() {
    if (keyCode == 10) {
      this.saidText = this.sayText;
      this.sayText = "";
      this.sayTextLines = 1;
    } else if (keyCode == 8 && this.sayText.length != 0) {
      this.sayText = this.sayText.substring(0, this.sayText.length - 1);
    } else if (this.sayableString.indexOf(key) != -1) {
      this.sayText += key;
    }

  }


  keyReleased() {

  }
}