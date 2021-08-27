class SoundScape {

  constructor() {

  }


  tick() {
    if (frameCount % 50 == 0) {
      SOUNDS[parseInt(random(12))].play(0);
    }
  }
}