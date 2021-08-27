class Clouds {

  constructor() {
    this.t = 0;
    this.TIME_INCREMENT = 1;
  }


  tick() {

    this.t--;
  }



  display() {

    let i = this.t;

    push();
    fill(255, 100.0);
    noStroke();


    let b = -100;

    let b1 = 100;

    while (b < width + 100) {

      if ((parseInt(noise(parseFloat(i) / parseFloat(T_RATIO)) * 1000.0) > 500 && parseInt(noise(parseFloat(i) / parseFloat(T_RATIO)) * 1000.0) < 510) || (

          parseInt(noise(parseFloat(i) / parseFloat(T_RATIO)) * 1000.0) > 200 && parseInt(noise(parseFloat(i) / parseFloat(T_RATIO)) * 1000.0) < 210)) {

        this.drawCloud(b, b1, i);

      }

      b++;

      i += this.TIME_INCREMENT;

    }
    pop();

  }



  drawCloud(param1Int1, param1Int2, param1Int3) {

    let i = param1Int3;

    let j = param1Int3 + 1000;

    let k = param1Int3 + 2000;




    for (let b = 0; b < 20; b++) {

      let m = parseInt((param1Int1 + parseInt((noise(parseFloat(i) / parseFloat(T_RATIO)) - 0.5) * 2.0 * 70.0)));

      let n = parseInt((param1Int2 + parseInt((noise(parseFloat(j) / parseFloat(T_RATIO)) - 0.5) * 2.0 * 20.0)));

      let i1 = parseInt((20 + parseInt(noise(parseFloat(k) / parseFloat(T_RATIO)) * 20.0)));

      ellipse(m, n, i1, i1);

      i += 1000;

      j += 1000;

      k += 1000;

    }

  }

}