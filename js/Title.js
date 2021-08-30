class Title

{
  constructor(param1World, param1Int1, param1Int2, param1String, param1Int3, param1Int4) {

    this.TIME_INCREMENT = 5;


    this.titleFill = 255;
    this.titleAlpha = 0;
    this.w = param1World;
    this.heightRange = param1Int1;
    this.baseY = param1Int2;
    this.title = param1String;

    this.startT = param1Int3;
    this.endT = param1Int4;
    this.titleSpacing = parseInt(((this.w.getX(this.endT) - this.w.getX(this.startT)) / this.title.length));


    // this.titleFont = loadFont("Helvetica-36.vlw");
  }




  display(param1Int) {

    if (this.titleAlpha == 0) {
      return;
    }

    push();
    textAlign(CENTER, BOTTOM);
    textFont(`sans-serif`);
    textSize(32)

    noStroke();
    fill(this.titleFill, this.titleAlpha);

    let x = 0;
    let y = 0;

    let t = this.startT;

    for (let b = 0; b < this.title.length; b++) {
      x = this.w.getX(this.startT) + (b * this.titleSpacing);
      y = this.w.getY(t);

      text(this.title[b], x, y);
      t += (this.TIME_INCREMENT * this.titleSpacing);
    }

    pop();

  }


  fadeIn(param1Int) {

    this.display(param1Int);

    this.titleAlpha = constrain(this.titleAlpha + 2, 0, 255);

  }


  fadeOut(param1Int) {

    this.display(param1Int);

    this.titleAlpha = constrain(this.titleAlpha - 5, 0, 255);

  }


  fullAlpha() {

    return (this.titleAlpha == 255);

  }


  minAlpha() {

    return (this.titleAlpha == 0);

  }

}