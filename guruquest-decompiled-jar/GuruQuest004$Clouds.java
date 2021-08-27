/*     */ import processing.core.PApplet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Clouds
/*     */ {
/* 251 */   int TIME_INCREMENT = 1;
/*     */   
/*     */   int t;
/*     */   int xOffset;
/*     */   
/*     */   Clouds() {
/* 257 */     this.t = 0;
/*     */   }
/*     */   
/*     */   public void tick() {
/* 261 */     this.t--;
/*     */   }
/*     */ 
/*     */   
/*     */   public void display() {
/* 266 */     int i = this.t;
/*     */     
/* 268 */     GuruQuest004.this.fill(255, 100.0F);
/* 269 */     GuruQuest004.this.noStroke();
/*     */     
/* 271 */     byte b = -100;
/* 272 */     byte b1 = 100;
/* 273 */     while (b < GuruQuest004.this.width + 100) {
/* 274 */       if ((PApplet.parseInt(GuruQuest004.this.noise(PApplet.parseFloat(i) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) * 1000.0F) > 500 && PApplet.parseInt(GuruQuest004.this.noise(PApplet.parseFloat(i) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) * 1000.0F) < 510) || (
/* 275 */         PApplet.parseInt(GuruQuest004.this.noise(PApplet.parseFloat(i) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) * 1000.0F) > 200 && PApplet.parseInt(GuruQuest004.this.noise(PApplet.parseFloat(i) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) * 1000.0F) < 210)) {
/* 276 */         drawCloud(b, b1, i);
/*     */       }
/* 278 */       b++;
/* 279 */       i += this.TIME_INCREMENT;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawCloud(int paramInt1, int paramInt2, int paramInt3) {
/* 285 */     int i = paramInt3;
/* 286 */     int j = paramInt3 + 1000;
/* 287 */     int k = paramInt3 + 2000;
/*     */ 
/*     */ 
/*     */     
/* 291 */     for (byte b = 0; b < 20; b++) {
/* 292 */       int m = PApplet.parseInt((paramInt1 + PApplet.parseInt((GuruQuest004.this.noise(PApplet.parseFloat(i) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) - 0.5F) * 2.0F * 70.0F)));
/* 293 */       int n = PApplet.parseInt((paramInt2 + PApplet.parseInt((GuruQuest004.this.noise(PApplet.parseFloat(j) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) - 0.5F) * 2.0F * 20.0F)));
/* 294 */       int i1 = PApplet.parseInt((20 + PApplet.parseInt(GuruQuest004.this.noise(PApplet.parseFloat(k) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) * 20.0F)));
/* 295 */       GuruQuest004.this.ellipse(m, n, i1, i1);
/* 296 */       i += 1000;
/* 297 */       j += 1000;
/* 298 */       k += 1000;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/pippinbarr/Dropbox/Develop/Processing/GuruQuest for Mac OS X/GuruQuest004.jar!/GuruQuest004$Clouds.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */