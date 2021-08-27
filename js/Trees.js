class Trees {



  constructor(param1World, param1Int1, param1Int2) {

    this.TIME_INCREMENT = 5;
    this.TREE_MAX_DELAY = 5;

    this.w = param1World;
    this.heightRange = param1Int1;
    this.baseY = param1Int2;
    this.treeDelay = 0;
  }



  display(param1Int) {

    let i = param1Int - 100;

    let j = this.w.getX(i);


    push();

    while (j < width + 100) {


      let k = parseInt(this.baseY + (noise(parseFloat(i) / parseFloat(T_RATIO)) - 0.5) * this.heightRange);


      if (parseInt(noise(parseFloat(i) / parseFloat(T_RATIO)) * 1000.0) % 15 == 0) {


        let m = parseInt(noise(parseFloat(i) / parseFloat(T_RATIO)) * 5.0 + 10.0);



        stroke(100.0, 80.0, 50.0);

        line(j, k, j, (k - m));



        stroke(50.0, 100.0, 50.0);

        for (let n = k - m; n < k - 3; n += 2) {

          line(j, n, (j - 3), (n + 3));

          line(j, n, (j + 3), (n + 3));

        }



        this.treeDelay = this.TREE_MAX_DELAY;

      } else if (this.treeDelay != 0) {


        this.treeDelay--;

      }



      i += this.TIME_INCREMENT;

      j++;

    }

    pop();

  }

}