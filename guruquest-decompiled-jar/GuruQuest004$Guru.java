/*     */ import codeanticode.eliza.Eliza;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Guru
/*     */   extends GuruQuest004.Person
/*     */ {
/* 381 */   int OUTGURU_MAX = 3;
/*     */   
/*     */   Eliza guru;
/*     */   
/*     */   Eliza guruTest;
/*     */   
/* 387 */   int h = 5;
/*     */   
/* 389 */   String[] wouldSay = new String[] {
/* 390 */       "", "", "", "", "", "", "", "", "", ""
/*     */     };
/* 392 */   Boolean outGuruable = Boolean.valueOf(true);
/* 393 */   Boolean consulted = Boolean.valueOf(false);
/*     */   
/* 395 */   int outGuruCount = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Guru(PApplet paramPApplet, GuruQuest004.World paramWorld, int paramInt) {
/* 403 */     super(paramWorld, paramInt);
/* 404 */     this.guru = new Eliza(paramPApplet);
/* 405 */     this.guru.readScript("GuruScript.txt");
/*     */ 
/*     */     
/* 408 */     this.guruTest = new Eliza(paramPApplet);
/* 409 */     this.guruTest.readScript("GuruScript.txt");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void processInput(String paramString) {
/* 421 */     if (!paramString.equals("") && this.w.inConversationRange()) {
/*     */       
/* 423 */       this.consulted = Boolean.valueOf(true);
/*     */       
/* 425 */       this.sayText = this.guru.processInput(paramString);
/* 426 */       this.sayText = this.sayText.replaceAll("\\s \\.", ".");
/* 427 */       this.sayText = this.sayText.replaceAll("\\s ,", ",");
/* 428 */       this.sayText = this.sayText.replaceAll("\\s \\?", "?");
/* 429 */       this.sayText = this.sayText.replaceAll("  ", " ");
/*     */       
/* 431 */       if (this.outGuruable.booleanValue()) {
/*     */ 
/*     */ 
/*     */         
/* 435 */         for (byte b1 = 0; b1 < this.wouldSay.length; b1++) {
/* 436 */           String str1 = this.wouldSay[b1].toLowerCase();
/* 437 */           str1 = str1.replaceAll("\\W", "");
/* 438 */           String str2 = paramString.replaceAll("\\W", "");
/* 439 */           GuruQuest004.println("Would say: " + str1);
/* 440 */           GuruQuest004.println("Simple input: " + str2);
/*     */           
/* 442 */           if (str2.equals(str1)) {
/*     */ 
/*     */             
/* 445 */             this.sayText = "Wise words.";
/* 446 */             this.outGuruCount++;
/* 447 */             this.w.outGurued();
/*     */ 
/*     */             
/* 450 */             if (this.outGuruCount == this.OUTGURU_MAX) {
/* 451 */               this.w.outGurued();
/* 452 */               this.w.guruStatusAchieved();
/*     */             } 
/*     */             
/* 455 */             this.outGuruable = Boolean.valueOf(false);
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */         
/* 461 */         if (!this.sayText.equals("Wise words.")) {
/* 462 */           this.outGuruCount = 0;
/*     */         }
/*     */       } else {
/*     */         
/* 466 */         this.outGuruable = Boolean.valueOf(true);
/*     */       } 
/*     */ 
/*     */       
/* 470 */       for (byte b = 0; b < this.wouldSay.length; b++) {
/* 471 */         this.wouldSay[b] = this.guruTest.processInput(this.sayText);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void display() {
/* 484 */     int i = this.w.getX(this.t);
/* 485 */     int j = this.w.getY(this.t) - 10;
/*     */ 
/*     */     
/* 488 */     GuruQuest004.this.stroke(255.0F, 0.0F, 0.0F);
/* 489 */     GuruQuest004.this.line(i, j, i, (j - 3));
/* 490 */     GuruQuest004.this.line((i - 1), j, (i + 1), j);
/* 491 */     GuruQuest004.this.line((i - 1), (j - 1), (i + 1), (j - 1));
/*     */     
/* 493 */     if (this.w.inConversationRange()) {
/* 494 */       super.display();
/*     */     } else {
/*     */       
/* 497 */       this.sayText = "";
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean consulted() {
/* 503 */     return this.consulted.booleanValue();
/*     */   }
/*     */ }


/* Location:              /Users/pippinbarr/Dropbox/Develop/Processing/GuruQuest for Mac OS X/GuruQuest004.jar!/GuruQuest004$Guru.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */