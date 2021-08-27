class Hills {



  constructor(param1World, param1Int1, param1Int2, param1Int3) {
    this.TIME_INCREMENT = 5;
    this.HILL_SHADOW_COLOUR = color(100, 100, 100);
    this.heightRange;
    this.w = param1World;
    this.heightRange = param1Int1;
    this.baseY = param1Int2;
    this.c = param1Int3;
  }

  display(param1Int) {
    this.drawHills(param1Int);
    this.drawShadows(param1Int);
  }

  drawHills(param1Int) {

    let i = param1Int;



    push();
    noStroke();
    fill(this.c);

    let j = 0;
    let b = 0;
    beginShape();
    while (b < width) {
      j = parseInt(this.baseY + (noise(parseFloat(i) / parseFloat(T_RATIO)) - 0.5) * this.heightRange);

      vertex(b, j);
      i += this.TIME_INCREMENT;
      b++;
    }

    vertex((width + 1), j);
    vertex((width + 1), (height + 1));
    vertex(-1.0, (height + 1));
    vertex(-1.0, j);
    endShape();
    pop();
  }

  drawShadows(param1Int) {

    let b = 0;

    let i = param1Int;

    let j = parseInt(this.baseY + (noise(parseFloat(i) / parseFloat(T_RATIO)) - 0.5) * this.heightRange);

    i += this.TIME_INCREMENT;

    push();
    while (b < width) {

      b++;
      let k = parseInt(this.baseY + (noise(parseFloat(i) / parseFloat(T_RATIO)) - 0.5) * this.heightRange);

      stroke(this.HILL_SHADOW_COLOUR);
      strokeWeight(1.0);


      if (parseInt(j) > parseInt(k)) {

        let m = parseInt(noise(parseFloat(i) / parseFloat(T_RATIO)) * 1000.0 % 15.0);

        line((b + 1), (j + 1), (b + m), (j + m));
      }
      i += this.TIME_INCREMENT;
      j = k;
    }

    pop();
  }

}