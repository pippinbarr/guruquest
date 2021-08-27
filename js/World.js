/**

*/
class World {

  /**

  */
  constructor() {
    this.guruStatusAchieved = false
    this.endGame = false;
    this.startGame = true;
    this.fadeToGame = false;
    this.preGame = false;
    this.playGame = false;
    this.creditsDisplay = false;

    this.TERRAIN_HEIGHT = 150;
    this.TERRAIN_BASE_Y = 2 * height / 3;
    this.PARALAX_HEIGHT = 200;
    this.PARALAX_OFFSET = 50000;
    this.PARALAX_TIME_RATIO = 2;
    this.PARALAX_BASE_Y = this.TERRAIN_BASE_Y - height / 6;
    this.HOEM_T = 1500;
    this.SCROLL_BOUNDARY = 200;
    this.GROUND_COLOR = color(150, 150, 160);
    this.PARALAX_COLOR = color(180, 180, 190);
    this.SKY_COLOR = color(200, 200, 250);
    this.DUSK_COLOR = color(100, 100, 120);
    this.TIME_INCREMENT = 5;
    this.t = 0;
    this.cloudT = 1000;
    this.cloudDelay = 0;
    this.CLOUD_DELAY = 200;
    this.insightFlashAlpha = 0;
    this.endGameAlpha = 0;
    this.treeDelay = 0;

    this.avatar = new Avatar(this, random(1500));
    this.guru = new Guru(this, random(5000));
    this.clouds = new Clouds(this);
    this.house = new House(this, 1500);
    this.pagoda = new Pagoda(this, 5000);
    this.foregroundHills = new Hills(this, 150, this.TERRAIN_BASE_Y, this.GROUND_COLOR);
    this.paralaxHills = new Hills(this, 120, this.PARALAX_BASE_Y, this.PARALAX_COLOR);
    this.trees = new Trees(this, 150, this.TERRAIN_BASE_Y);
    this.title = new Title(this, 150, this.TERRAIN_BASE_Y, `GURUQUEST`, this.house.getT() + 250, this.pagoda.getT() + 150);

    const introductionText = `YOU'VE HEARD TELL OF A GURU TO THE EAST.
WILL YOU SEEK THE GURU?
OR WILL YOU SEEK TO BE THE GURU?`;
    console.log(color(75, 80, 90));
    this.introduction = new GameText(introductionText, width / 2, height / 4, color(75, 80, 90), 10, 5, 200, 255, `center`);

    const leavingInstructionsText = `↓ TO LEAVE HOME`;
    this.leavingInstructions = new GameText(leavingInstructionsText, this.house.getX(), this.house.getY() - 100, -1, 15, 15, 0, 0, "center");

    const instructionsText = `TYPE TO TALK
→ AND ← TO WALK
↑ TO RETURN HOME
AFTER YOUR QUEST`;
    this.instructions = new GameText(instructionsText, this.house.getX(), this.house.getY() - 100, -1, 15, 15, 0, 0, "center");

    this.blackScreen = new GameText("", 0, 0, 0, 1, 0, 0, 0, "left");

    this.credits = new GameText(`BY PIPPIN BARR`, this.pagoda.getX(), height / 2 + 150, -1, 5, 0, 200, 0, "right");
  }

  /**

  */
  tick() {
    if (this.startGame) {
      background(0);
      this.introduction.display();
      if (frameCount > 30) {
        this.title.fadeIn(this.t);
      }
      if (this.title.fullAlpha()) {
        this.startGame = false;
        this.fadeToGame = true;
      }
    } else if (this.fadeToGame) {
      this.display();
      this.introduction.fadeOut();
      this.title.display(this.t);
      this.clouds.tick();
      if (this.introduction.minAlpha()) {
        this.fadeToGame = false;
        this.preGame = true;
      }
    } else if (this.preGame) {
      this.display();
      this.clouds.tick();
      this.house.tick();
      if (!this.title.minAlpha()) {
        this.title.fadeOut(this.t);
      } else {

        this.leavingInstructions.fadeIn();
      }

    } else if (this.playGame) {
      if (frameCount > frameRate * 600) this.fadeToDusk();

      this.avatar.handleInput();
      this.display();
      this.clouds.tick();
      this.house.tick();


      if (!this.leavingInstructions.minAlpha()) {
        this.leavingInstructions.fadeOut();
      } else if (this.house.inFront(this.avatar.getX())) {
        this.instructions.fadeIn();
      } else if (!this.instructions.minAlpha()) {
        this.instructions.fadeOut();
      }
      this.guru.processInput(this.avatar.said());
    } else if (this.endGame) {
      this.clouds.tick();
      this.house.tick();
      this.display();
      this.scrollToStart();
    } else if (this.creditsDisplay) {
      this.display();
      if (!this.blackScreen.maxAlpha()) {
        this.clouds.tick();
        this.house.tick();
      }

      this.blackScreen.fadeIn();
      this.title.fadeIn(this.t);
      if (this.blackScreen.maxAlpha()) {
        this.credits.fadeIn();
      }

      if (this.house.isOccupied()) {
        this.house.drawWindows();
      } else if (this.avatar.guruStatus()) {
        this.avatar.display();
      }
    }
  }

  display() {
    background(this.SKY_COLOR);
    this.paralaxHills.display((this.t + 50000) / 2);
    this.trees.display(this.t);

    if (this.onScreen(this.pagoda.getT())) {
      this.pagoda.display();
    }

    if (this.onScreen(this.house.getT())) {
      this.house.display();
    }
    this.foregroundHills.display(this.t);
    this.clouds.display();

    if (this.insightFlashAlpha != 0) {
      fill(255, this.insightFlashAlpha);
      noStroke();
      rect(0.0, 0.0, width, height);
      this.insightFlashAlpha = constrain(this.insightFlashAlpha - 30, 0, 255);
    }

    if (!this.guruStatusAchieved) {
      this.guru.display();
    }

    this.avatar.display();
  }

  outGurued() {
    this.insightFlashAlpha = 255;
  }


  guruStatusAchieved() {
    this.guruStatusAchieved = true;
    this.avatar.becomeGuru(this.guru.getT());
    this.endTheGame();
  }

  getX(t) {
    return parseInt(((t - this.t) / 5));
  }

  getY(t) {
    return parseInt(this.TERRAIN_BASE_Y + (noise(t / T_RATIO) - 0.5) * 150.0);
  }

  guruStatusAchieved() {
    this.guruStatusAchieved = true;
    this.avatar.becomeGuru(this.guru.getT());
    this.endTheGame();
  }

  onScreen(t) {
    return (this.getX(t) > -100 && this.getX(t) < width + 100);
  }

  avatarMoved(param1Int1, param1Int2) {
    this.getX(param1Int1);
    this.getX(param1Int1);
  }

  inConversationRange() {
    if (this.getX(this.guru.getT()) > this.getX(this.avatar.getT()) - 200 &&
      this.getX(this.guru.getT()) < this.getX(this.avatar.getT()) + 200) {
      return true;
    } else {
      return false;
    }
  }

  endTheGame() {
    this.endGame = true;
    this.playGame = false;
    this.endGameAlpha = 0;
  }


  fadeToDusk() {
    if (frameCount % 20 == 0) {
      let f1 = red(this.SKY_COLOUR);
      let f2 = green(this.SKY_COLOUR);
      let f3 = blue(this.SKY_COLOUR);
      if (f1 != red(this.DUSK_COLOUR)) f1--;
      if (f2 != green(this.DUSK_COLOUR)) f2--;
      if (f3 != blue(this.DUSK_COLOUR)) f3--;
      this.SKY_COLOUR = color(f1, f2, f3);
    }

  }


  scrollToStart() {

    if (this.t > 0) {
      this.t -= 10;
    } else if (this.t < 0) {
      this.t += 10;
    } else if (this.t == 0) {
      this.endGame = false;
      this.creditsDisplay = true;
    }

  }



  keyPressed() {
    if (keyCode == 40 && this.avatar.atHome && this.preGame) {
      this.avatar.atHome = false;
      this.house.avatarLeft();
      this.preGame = false;
      this.playGame = true;
    } else if (keyCode == 38 && !this.avatar.atHome && this.house.inFront(this.avatar.getX()) && this.guru.consulted) {
      this.avatar.atHome = true;
      this.house.avatarEntered();
      this.endTheGame();
    }
  }

}