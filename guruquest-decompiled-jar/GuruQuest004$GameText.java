/*     */ import processing.core.PFont;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GameText
/*     */ {
/*     */   String s;
/*     */   int x;
/*     */   int y;
/*     */   int inSpeed;
/*     */   int outSpeed;
/*     */   int gameTextFill;
/* 312 */   int gameTextAlpha = 255;
/*     */   int bg;
/* 314 */   int bgAlpha = 255;
/*     */   
/*     */   String align;
/*     */   PFont f;
/*     */   
/*     */   GameText(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2) {
/* 320 */     this.s = paramString1;
/* 321 */     this.x = paramInt1;
/* 322 */     this.y = paramInt2;
/* 323 */     this.bg = paramInt3;
/* 324 */     this.inSpeed = paramInt4;
/* 325 */     this.outSpeed = paramInt5;
/* 326 */     this.gameTextFill = paramInt6;
/* 327 */     this.gameTextAlpha = paramInt7;
/* 328 */     this.bgAlpha = paramInt7;
/* 329 */     this.align = paramString2;
/* 330 */     this.f = paramGuruQuest004.loadFont("Helvetica-14.vlw");
/*     */   }
/*     */ 
/*     */   
/*     */   public void display() {
/* 335 */     if (this.bg != -1) {
/* 336 */       GuruQuest004.this.noStroke();
/* 337 */       GuruQuest004.this.fill(this.bg, this.bgAlpha);
/* 338 */       GuruQuest004.this.rect(0.0F, 0.0F, GuruQuest004.this.width, GuruQuest004.this.height);
/*     */     } 
/* 340 */     GuruQuest004.this.textFont(this.f);
/* 341 */     GuruQuest004.this.textAlign(3);
/* 342 */     if (this.align.equals("left")) GuruQuest004.this.textAlign(37); 
/* 343 */     if (this.align.equals("right")) GuruQuest004.this.textAlign(39); 
/* 344 */     if (this.align.equals("center")) GuruQuest004.this.textAlign(3); 
/* 345 */     GuruQuest004.this.fill(this.gameTextFill, this.gameTextAlpha);
/* 346 */     GuruQuest004.this.text(this.s, this.x, this.y);
/*     */   }
/*     */   
/*     */   public void fadeOut() {
/* 350 */     this.bgAlpha = GuruQuest004.constrain(this.bgAlpha - this.outSpeed, 0, 255);
/* 351 */     this.gameTextAlpha = GuruQuest004.constrain(this.gameTextAlpha - this.outSpeed, 0, 255);
/* 352 */     display();
/*     */   }
/*     */   
/*     */   public void fadeIn() {
/* 356 */     this.bgAlpha = GuruQuest004.constrain(this.bgAlpha + this.inSpeed, 0, 255);
/* 357 */     this.gameTextAlpha = GuruQuest004.constrain(this.gameTextAlpha + this.inSpeed, 0, 255);
/* 358 */     display();
/*     */   }
/*     */   
/*     */   public boolean minAlpha() {
/* 362 */     return (this.bgAlpha == 0 && this.gameTextAlpha == 0);
/*     */   }
/*     */   
/*     */   public boolean maxAlpha() {
/* 366 */     return (this.bgAlpha == 255 && this.gameTextAlpha == 255);
/*     */   }
/*     */ }


/* Location:              /Users/pippinbarr/Dropbox/Develop/Processing/GuruQuest for Mac OS X/GuruQuest004.jar!/GuruQuest004$GameText.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */