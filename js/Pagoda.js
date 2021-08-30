class Pagoda

{

  constructor(param1World, param1Int) {

    this.PAGODA_BASE_WIDTH = 21;
    this.w = param1World;
    this.t = param1Int;
    this.tiers = parseInt(noise(parseFloat(this.t) / parseFloat(T_RATIO)) * 4.0) + 4;
  }



  display() {

    let i = this.w.getX(this.t);

    let j = this.w.getY(this.t);

    push();
    rectMode(CENTER);

    for (let b = 0; b < this.tiers; b++) {

      fill(30);
      stroke(30);
      rect(i, (j - b * 10), this.PAGODA_BASE_WIDTH, 10.0);
      triangle((i - 15), (j - b * 10 - 2), (i + 15), (j - b * 10 - 2), i, (j - b * 10 - 12));
      if (b > 1) {
        stroke(150);
        line((i - (this.PAGODA_BASE_WIDTH - 1) / 2), (j - b * 10 - 2), (i + (this.PAGODA_BASE_WIDTH - 1) / 2), (j - b * 10 - 2));
        if (b > 2 && b < this.tiers) {
          rect(i, (j - (b - 1) * 10 - 6), 2.0, 2.0);
        }
        for (let b1 = 1; b1 < 20; b1 += 2) {
          point((i - 10 + b1), (j - b * 10 - 1));
        }
      }
    }

    noStroke();

    triangle(i, (j - this.tiers * 10), (i - 3), (j - this.tiers * 10 - 3), (i + 3), (j - this.tiers * 10 - 3));
    triangle(i, (j - this.tiers * 10 - 6), (i - 3), (j - this.tiers * 10 - 3), (i + 3), (j - this.tiers * 10 - 3));

    stroke(150);
    line((i - 8), (j - 2), (i + 8), (j - 2));
    line((i - 6), (j - 4), (i + 6), (j - 4));
    line((i - 4), (j - 6), (i + 4), (j - 6));
    line((i - 2), (j - 8), (i + 2), (j - 8));
    line((i - 6), (j - 4), (i - 6), (j - 18));
    line((i + 6), (j - 18), (i + 6), (j - 4));
    pop();
  }


  getT() {

    return this.t;

  }


  getX() {

    return this.w.getX(this.t);

  }

}