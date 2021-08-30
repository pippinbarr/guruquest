class Person {

  /**

  */
  constructor(w, t) {
    this.w = w;
    this.t = t;
    this.sayText = ``;
    this.saidText = ``;
    this.sayTextLines = 1;
    this.lineHeight = textAscent() + textDescent() + 2;
    this.charWidth = 10;
    this.LINE_LENGTH = 15;
    this.sayAlpha = 220;
  }

  /**

  */
  display() {
    // this.sayText = `I CAME I SAW I CONQUERED and then Ijkdljkldjlkdjldkjlkdhome`

    // Adapted from: https://stackoverflow.com/a/14487422
    function wordWrap(str, maxWidth) {
      let newLineStr = "\n";
      let done = false;
      let res = '';
      let lines = 1;
      while (str.length > maxWidth) {
        let found = false;
        // Inserts new line at first whitespace of the line
        for (let i = maxWidth - 1; i >= 0; i--) {
          if (str.charAt(i) == ` `) {
            res = res + [str.slice(0, i), newLineStr].join('');
            str = str.slice(i + 1);
            found = true;
            lines++;
            break;
          }
        }
        // Inserts new line at maxWidth position, the word is too long to wrap
        if (!found) {
          res += [str.slice(0, maxWidth), newLineStr].join('');
          str = str.slice(maxWidth);
          lines++;
        }

      }
      let result = res + str;

      return {
        string: result,
        lines: lines
      }
    }

    let displayResult = wordWrap(this.sayText, this.LINE_LENGTH);
    if (displayResult.string.length > 0) {
      this.drawBalloon(displayResult.string, this.LINE_LENGTH, displayResult.lines);
    }
  }

  /**

  */
  drawBalloon(str, lineLength, lines) {
    let x = this.w.getX(this.t);
    let y = this.w.getY(this.t);

    push();
    fill(255, this.sayAlpha);
    stroke(200, this.sayAlpha);
    beginShape();
    vertex(x, y - 20);
    vertex(x, y - 80);
    vertex(x - lineLength * this.charWidth / 2 - 5, y - 80);
    vertex(x - lineLength * this.charWidth / 2 - 5, y - 80 - (lines + 1) * this.lineHeight);
    vertex(x + lineLength * this.charWidth / 2 + 5, y - 80 - (lines + 1) * this.lineHeight);
    vertex(x + lineLength * this.charWidth / 2 + 5, y - 80);
    vertex(x + 5, y - 80);
    vertex(x, y - 20);
    endShape();
    pop();

    push()
    fill(50, this.sayAlpha);
    noStroke();
    textFont(`Courier`);
    textSize(12);
    this.lineHeight = textAscent() + textDescent();
    textAlign(CENTER, TOP); // ???
    text(str.toUpperCase(), x, y - 80 - ((lines + 0.5) * this.lineHeight) + 2);
  }




  /**

  */
  said() {
    if (this.saidText.length > 0) {
      const str = this.saidText;
      this.saidText = ``;
      return str;
    } else {
      return ``;
    }
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

}