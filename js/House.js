class House {
  constructor(param1World, param1Int) {

    this.HOME_WIDTH = 20;
    this.PUFF_CIRCLES = 10;
    this.BRICK_COLOUR = color(150, 20, 10);
    this.FOUNDATION_COLOUR = color(220, 220, 220);
    this.ROOF_COLOUR = color(60, 60, 0);
    this.TRIMMING_COLOUR = color(200);
    this.LIGHTS_ON = color(250, 250, 100);
    this.LIGHTS_OFF = color(50);
    this.SMOKE_COLOUR = color(240, 30);

    this.w = param1World;
    this.t = param1Int;

    this.occupied = true;
    this.smokeHeight = 0;
    this.smokeOffset = 0;

  }



  tick() {}



  display() {

    let i = this.w.getX(this.t);

    let j = this.w.getY(this.t);


    push();
    noStroke();

    rectMode(0);


    fill(this.BRICK_COLOUR);

    rect((i - this.HOME_WIDTH / 2), (j - this.HOME_WIDTH), this.HOME_WIDTH, this.HOME_WIDTH);

    rect((i + this.HOME_WIDTH / 2 - 3), (j - this.HOME_WIDTH - this.HOME_WIDTH / 2), 3.0, 60.0);
    fill(this.FOUNDATION_COLOUR);

    rect((i - this.HOME_WIDTH / 2), j, this.HOME_WIDTH, this.HOME_WIDTH);

    fill(this.ROOF_COLOUR);


    triangle((i - this.HOME_WIDTH / 2 - 5), (j - this.HOME_WIDTH + 5), (i + this.HOME_WIDTH / 2 + 5), (j - this.HOME_WIDTH + 5), i, (j - this.HOME_WIDTH - this.HOME_WIDTH / 2));


    stroke(this.TRIMMING_COLOUR);


    rect((i - 2), (j - 10), 4.0, 9.0);


    if (this.occupied) {

      fill(this.LIGHTS_ON);

    } else {


      fill(this.LIGHTS_OFF);

    }

    rect((i - 8), (j - 10), 3.0, 3.0);

    rect((i + 5), (j - 10), 3.0, 3.0);


    if (this.occupied || this.smokeOffset <= this.smokeHeight) {

      this.drawSmoke();

    } else {

      this.smokeHeight = 0;
    }

    pop();

  }


  drawWindows() {
    let i = this.w.getX(this.t);
    let j = this.w.getY(this.t);

    push();
    fill(this.LIGHTS_ON);
    rect((i - 8), (j - 10), 3.0, 3.0);
    rect((i + 5), (j - 10), 3.0, 3.0);
    pop();
  }




  drawSmoke() {

    let i = this.w.getX(this.t) + this.HOME_WIDTH / 2 - 2;

    let j = this.w.getY(this.t) - this.HOME_WIDTH - this.HOME_WIDTH / 2 - 5;

    push()
    noStroke();

    fill(this.SMOKE_COLOUR);

    for (let k = this.smokeOffset; k < this.smokeHeight; k++) {

      for (let b = 0; b < this.PUFF_CIRCLES; b++) {

        let m = i + parseInt(random(-2.0, 2.0));

        let n = j - k * 2 - parseInt(random(-3.0, 3.0));

        let i1 = parseInt(random((k / 10), (k / 6))) * 1 + 2;

        ellipse(m, n, i1, i1);

      }

    }


    this.smokeHeight = constrain(this.smokeHeight + 1, 0, j);

    if (!this.occupied) {

      this.smokeOffset = constrain(this.smokeOffset + 1, 0, this.smokeHeight);

    }

  }



  avatarEntered() {

    this.occupied = true;

    this.smokeHeight = 0;

    this.smokeOffset = 0;

  }


  avatarLeft() {

    this.occupied = false;

    this.smokeOffset = 0;

  }


  getT() {

    return this.t;

  }


  getX() {

    return this.w.getX(this.t);

  }


  getY() {

    return this.w.getY(this.t);

  }


  isOccupied() {

    return this.occupied;

  }


  inFront(param1Int) {

    return (param1Int > this.w.getX(this.t) - this.HOME_WIDTH / 2 && param1Int < this.w.getX(this.t) + this.HOME_WIDTH / 2);

  }

}