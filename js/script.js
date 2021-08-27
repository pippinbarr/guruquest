/**
Title of Project
Author Name

This is a template. You must fill in the title,
author, and this description to match your project!
*/

"use strict";

const eliza = new ElizaBot();
const firstWords = eliza.getInitial();
const response = eliza.transform(`input`);

const T_RATIO = 1000;
let world;
let soundscape;
let soundScapeStarted = false;
let keysPressed = 0;

const SOUNDS = [];

/**
Description of preload
*/
function preload() {
  for (let i = 0; i < 12; i++) {
    let sound = loadSound(`assets/sounds/${i+1}.wav`);
    SOUNDS.push(sound);
  }
}


/**
Description of setup
*/
function setup() {
  createCanvas(1280, 400);
  frameRate(30);
  world = new World();
  soundscape = new SoundScape();
  background(0);
}


/**
Description of draw()
*/
function draw() {
  soundscape.tick();
  world.tick();
}

/**

*/
function keyPressed() {
  world.keyPressed();
}