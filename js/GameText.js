class GameText

{



  constructor(param1String1, param1Int1, param1Int2, param1Int3, param1Int4, param1Int5, param1Int6, param1Int7, param1String2) {
    this.gameTextAlpha = 255;
    this.bgAlpha = 255;
    this.s = param1String1;
    this.x = param1Int1;
    this.y = param1Int2;
    this.bg = param1Int3;
    this.inSpeed = param1Int4;
    this.outSpeed = param1Int5;
    this.gameTextFill = param1Int6;
    this.gameTextAlpha = param1Int7;
    this.bgAlpha = param1Int7;
    this.align = param1String2;
    // this.f = loadFont("Helvetica-14.vlw");
  }



  display() {

    if (this.bg != -1) {
      noStroke();
      fill(this.bg, this.bgAlpha);
      rect(0.0, 0.0, width, height);
    }

    noStroke();

    textFont(`Helvetica`);

    textAlign(3);

    if (this.align == "left") textAlign(37);

    if (this.align == "right") textAlign(39);

    if (this.align == "center") textAlign(3);

    fill(this.gameTextFill, this.gameTextAlpha);

    text(this.s, this.x, this.y);

  }


  fadeOut() {

    this.bgAlpha = constrain(this.bgAlpha - this.outSpeed, 0, 255);

    this.gameTextAlpha = constrain(this.gameTextAlpha - this.outSpeed, 0, 255);

    this.display();

  }


  fadeIn() {

    this.bgAlpha = constrain(this.bgAlpha + this.inSpeed, 0, 255);

    this.gameTextAlpha = constrain(this.gameTextAlpha + this.inSpeed, 0, 255);

    this.display();

  }


  minAlpha() {

    return (this.bgAlpha == 0 && this.gameTextAlpha == 0);

  }


  maxAlpha() {

    return (this.bgAlpha == 255 && this.gameTextAlpha == 255);

  }

}