/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Avatar
/*     */   extends GuruQuest004.Person
/*     */ {
/*     */   int h;
/*     */   int avatarColour;
/*  83 */   String sayableString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ !@#$%^&*()_-+=1234567890?/,.'\";:][{}";
/*     */   
/*     */   boolean meditating;
/*     */   
/*     */   boolean atHome;
/*     */   
/*     */   boolean guruStatus;
/*     */   boolean walking;
/*  91 */   int walkCyclePosition = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Avatar(GuruQuest004.World paramWorld, int paramInt) {
/*  99 */     super(paramWorld, paramInt);
/* 100 */     this.avatarColour = paramGuruQuest004.color(0, 0, 0);
/* 101 */     this.meditating = false;
/* 102 */     this.walking = false;
/* 103 */     this.atHome = true;
/* 104 */     this.guruStatus = false;
/* 105 */     this.h = 5;
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
/*     */   
/*     */   public void display() {
/* 118 */     if (this.atHome) {
/*     */       return;
/*     */     }
/*     */     
/* 122 */     int i = this.w.getX(this.t) - 1;
/* 123 */     int j = this.w.getY(this.t) - 1;
/*     */     
/* 125 */     GuruQuest004.this.stroke(this.avatarColour);
/*     */     
/* 127 */     if (!this.meditating && !this.guruStatus) {
/* 128 */       if (!this.walking)
/*     */       {
/* 130 */         GuruQuest004.this.line(i, (j - 2), i, (j - this.h));
/* 131 */         GuruQuest004.this.line((i - 1), j, (i - 1), (j - 1));
/* 132 */         GuruQuest004.this.line((i + 1), j, (i + 1), (j - 1));
/* 133 */         GuruQuest004.this.line((i - 1), (j - 3), (i + 1), (j - 3));
/*     */       }
/* 135 */       else if (this.walking)
/*     */       {
/* 137 */         if (this.walkCyclePosition == 0) {
/* 138 */           GuruQuest004.this.line(i, (j - 1), i, (j - this.h));
/* 139 */           GuruQuest004.this.point((i - 1), (j - 1));
/* 140 */           GuruQuest004.this.point((i + 1), j);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         }
/* 148 */         else if (this.walkCyclePosition == 1) {
/* 149 */           GuruQuest004.this.line(i, (j - 1), i, (j - this.h));
/* 150 */           GuruQuest004.this.point((i - 1), j);
/*     */           
/* 152 */           GuruQuest004.this.point((i + 1), (j - 1));
/*     */         } 
/* 154 */         if (GuruQuest004.this.frameCount % 5 == 0)
/*     */         {
/* 156 */           this.walkCyclePosition = 1 - this.walkCyclePosition;
/*     */         }
/*     */       }
/*     */     
/* 160 */     } else if (this.guruStatus) {
/* 161 */       i = this.w.getX(this.t);
/* 162 */       j = this.w.getY(this.t) - 10;
/*     */ 
/*     */       
/* 165 */       GuruQuest004.this.stroke(255.0F, 0.0F, 0.0F);
/* 166 */       GuruQuest004.this.line(i, j, i, (j - 3));
/* 167 */       GuruQuest004.this.line((i - 1), j, (i + 1), j);
/* 168 */       GuruQuest004.this.line((i - 1), (j - 1), (i + 1), (j - 1));
/*     */     } else {
/*     */       
/* 171 */       GuruQuest004.this.line(i, j, i, (j - 3));
/* 172 */       GuruQuest004.this.line((i - 1), j, (i + 1), j);
/* 173 */       GuruQuest004.this.line((i - 1), (j - 1), (i + 1), (j - 1));
/*     */     } 
/* 175 */     super.display();
/*     */   }
/*     */   
/*     */   public void becomeGuru(int paramInt) {
/* 179 */     this.t = paramInt;
/* 180 */     this.guruStatus = true;
/* 181 */     this.avatarColour = GuruQuest004.this.color(255, 0, 0);
/*     */   }
/*     */   
/*     */   public boolean guruStatus() {
/* 185 */     return this.guruStatus;
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
/*     */   public void keyPressed() {
/* 197 */     if (!this.atHome && !this.meditating && !this.guruStatus) {
/* 198 */       if (GuruQuest004.this.keyCode == 37) {
/*     */         
/* 200 */         this.t -= 10;
/* 201 */         this.w.avatarMoved(this.t, -10);
/*     */       }
/* 203 */       else if (GuruQuest004.this.keyCode == 39) {
/*     */         
/* 205 */         this.t += 10;
/* 206 */         this.w.avatarMoved(this.t, 10);
/*     */       }
/* 208 */       else if (GuruQuest004.this.keyCode == 40) {
/*     */       
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 215 */       if (GuruQuest004.this.keyCode == 10) {
/* 216 */         this.saidText = this.sayText;
/* 217 */         this.sayText = "";
/* 218 */         this.sayTextLines = 1;
/*     */ 
/*     */       
/*     */       }
/* 222 */       else if (GuruQuest004.this.keyCode == 8 && this.sayText.length() != 0) {
/* 223 */         this.sayText = this.sayText.substring(0, this.sayText.length() - 1);
/*     */ 
/*     */       
/*     */       }
/* 227 */       else if (this.sayableString.indexOf(GuruQuest004.this.key) != -1) {
/* 228 */         this.sayText = String.valueOf(this.sayText) + GuruQuest004.this.key;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void keyReleased() {
/* 237 */     if (this.atHome || this.meditating || this.guruStatus || 
/* 238 */       GuruQuest004.this.keyCode != 37);
/*     */   }
/*     */ }


/* Location:              /Users/pippinbarr/Dropbox/Develop/Processing/GuruQuest for Mac OS X/GuruQuest004.jar!/GuruQuest004$Avatar.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */