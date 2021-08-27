/*      */ import codeanticode.eliza.Eliza;
/*      */ import ddf.minim.AudioSnippet;
/*      */ import ddf.minim.Minim;
/*      */ import java.awt.Color;
/*      */ import processing.core.PApplet;
/*      */ import processing.core.PFont;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class GuruQuest004
/*      */   extends PApplet
/*      */ {
/*   23 */   int T_RATIO = 1000;
/*      */ 
/*      */ 
/*      */   
/*      */   World world;
/*      */ 
/*      */   
/*      */   SoundScape soundscape;
/*      */ 
/*      */ 
/*      */   
/*      */   public void setup() {
/*   35 */     size(1280, 400);
/*   36 */     frameRate(30.0F);
/*      */     
/*   38 */     this.world = new World(this);
/*   39 */     this.soundscape = new SoundScape(this);
/*      */ 
/*      */ 
/*      */     
/*   43 */     this.frame.setBackground(new Color(0, 0, 0));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void draw() {
/*   53 */     this.soundscape.tick();
/*   54 */     this.world.tick();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void keyPressed() {
/*   63 */     this.world.keyPressed();
/*      */   }
/*      */   
/*      */   public void keyReleased() {
/*   67 */     this.world.keyReleased();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class Avatar
/*      */     extends Person
/*      */   {
/*      */     int h;
/*      */ 
/*      */ 
/*      */     
/*      */     int avatarColour;
/*      */ 
/*      */     
/*   83 */     String sayableString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ !@#$%^&*()_-+=1234567890?/,.'\";:][{}";
/*      */     
/*      */     boolean meditating;
/*      */     
/*      */     boolean atHome;
/*      */     
/*      */     boolean guruStatus;
/*      */     boolean walking;
/*   91 */     int walkCyclePosition = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Avatar(GuruQuest004.World param1World, int param1Int) {
/*   99 */       super(param1World, param1Int);
/*  100 */       this.avatarColour = GuruQuest004.this.color(0, 0, 0);
/*  101 */       this.meditating = false;
/*  102 */       this.walking = false;
/*  103 */       this.atHome = true;
/*  104 */       this.guruStatus = false;
/*  105 */       this.h = 5;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void display() {
/*  118 */       if (this.atHome) {
/*      */         return;
/*      */       }
/*      */       
/*  122 */       int i = this.w.getX(this.t) - 1;
/*  123 */       int j = this.w.getY(this.t) - 1;
/*      */       
/*  125 */       GuruQuest004.this.stroke(this.avatarColour);
/*      */       
/*  127 */       if (!this.meditating && !this.guruStatus) {
/*  128 */         if (!this.walking)
/*      */         {
/*  130 */           GuruQuest004.this.line(i, (j - 2), i, (j - this.h));
/*  131 */           GuruQuest004.this.line((i - 1), j, (i - 1), (j - 1));
/*  132 */           GuruQuest004.this.line((i + 1), j, (i + 1), (j - 1));
/*  133 */           GuruQuest004.this.line((i - 1), (j - 3), (i + 1), (j - 3));
/*      */         }
/*  135 */         else if (this.walking)
/*      */         {
/*  137 */           if (this.walkCyclePosition == 0) {
/*  138 */             GuruQuest004.this.line(i, (j - 1), i, (j - this.h));
/*  139 */             GuruQuest004.this.point((i - 1), (j - 1));
/*  140 */             GuruQuest004.this.point((i + 1), j);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           }
/*  148 */           else if (this.walkCyclePosition == 1) {
/*  149 */             GuruQuest004.this.line(i, (j - 1), i, (j - this.h));
/*  150 */             GuruQuest004.this.point((i - 1), j);
/*      */             
/*  152 */             GuruQuest004.this.point((i + 1), (j - 1));
/*      */           } 
/*  154 */           if (GuruQuest004.this.frameCount % 5 == 0)
/*      */           {
/*  156 */             this.walkCyclePosition = 1 - this.walkCyclePosition;
/*      */           }
/*      */         }
/*      */       
/*  160 */       } else if (this.guruStatus) {
/*  161 */         i = this.w.getX(this.t);
/*  162 */         j = this.w.getY(this.t) - 10;
/*      */ 
/*      */         
/*  165 */         GuruQuest004.this.stroke(255.0F, 0.0F, 0.0F);
/*  166 */         GuruQuest004.this.line(i, j, i, (j - 3));
/*  167 */         GuruQuest004.this.line((i - 1), j, (i + 1), j);
/*  168 */         GuruQuest004.this.line((i - 1), (j - 1), (i + 1), (j - 1));
/*      */       } else {
/*      */         
/*  171 */         GuruQuest004.this.line(i, j, i, (j - 3));
/*  172 */         GuruQuest004.this.line((i - 1), j, (i + 1), j);
/*  173 */         GuruQuest004.this.line((i - 1), (j - 1), (i + 1), (j - 1));
/*      */       } 
/*  175 */       super.display();
/*      */     }
/*      */     
/*      */     public void becomeGuru(int param1Int) {
/*  179 */       this.t = param1Int;
/*  180 */       this.guruStatus = true;
/*  181 */       this.avatarColour = GuruQuest004.this.color(255, 0, 0);
/*      */     }
/*      */     
/*      */     public boolean guruStatus() {
/*  185 */       return this.guruStatus;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void keyPressed() {
/*  197 */       if (!this.atHome && !this.meditating && !this.guruStatus) {
/*  198 */         if (GuruQuest004.this.keyCode == 37) {
/*      */           
/*  200 */           this.t -= 10;
/*  201 */           this.w.avatarMoved(this.t, -10);
/*      */         }
/*  203 */         else if (GuruQuest004.this.keyCode == 39) {
/*      */           
/*  205 */           this.t += 10;
/*  206 */           this.w.avatarMoved(this.t, 10);
/*      */         }
/*  208 */         else if (GuruQuest004.this.keyCode == 40) {
/*      */         
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  215 */         if (GuruQuest004.this.keyCode == 10) {
/*  216 */           this.saidText = this.sayText;
/*  217 */           this.sayText = "";
/*  218 */           this.sayTextLines = 1;
/*      */ 
/*      */         
/*      */         }
/*  222 */         else if (GuruQuest004.this.keyCode == 8 && this.sayText.length() != 0) {
/*  223 */           this.sayText = this.sayText.substring(0, this.sayText.length() - 1);
/*      */ 
/*      */         
/*      */         }
/*  227 */         else if (this.sayableString.indexOf(GuruQuest004.this.key) != -1) {
/*  228 */           this.sayText = String.valueOf(this.sayText) + GuruQuest004.this.key;
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void keyReleased() {
/*  237 */       if (this.atHome || this.meditating || this.guruStatus || 
/*  238 */         GuruQuest004.this.keyCode != 37);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class Clouds
/*      */   {
/*  251 */     int TIME_INCREMENT = 1;
/*      */     
/*      */     int t;
/*      */     int xOffset;
/*      */     
/*      */     Clouds() {
/*  257 */       this.t = 0;
/*      */     }
/*      */     
/*      */     public void tick() {
/*  261 */       this.t--;
/*      */     }
/*      */ 
/*      */     
/*      */     public void display() {
/*  266 */       int i = this.t;
/*      */       
/*  268 */       GuruQuest004.this.fill(255, 100.0F);
/*  269 */       GuruQuest004.this.noStroke();
/*      */       
/*  271 */       byte b = -100;
/*  272 */       byte b1 = 100;
/*  273 */       while (b < GuruQuest004.this.width + 100) {
/*  274 */         if ((PApplet.parseInt(GuruQuest004.this.noise(PApplet.parseFloat(i) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) * 1000.0F) > 500 && PApplet.parseInt(GuruQuest004.this.noise(PApplet.parseFloat(i) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) * 1000.0F) < 510) || (
/*  275 */           PApplet.parseInt(GuruQuest004.this.noise(PApplet.parseFloat(i) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) * 1000.0F) > 200 && PApplet.parseInt(GuruQuest004.this.noise(PApplet.parseFloat(i) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) * 1000.0F) < 210)) {
/*  276 */           drawCloud(b, b1, i);
/*      */         }
/*  278 */         b++;
/*  279 */         i += this.TIME_INCREMENT;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void drawCloud(int param1Int1, int param1Int2, int param1Int3) {
/*  285 */       int i = param1Int3;
/*  286 */       int j = param1Int3 + 1000;
/*  287 */       int k = param1Int3 + 2000;
/*      */ 
/*      */ 
/*      */       
/*  291 */       for (byte b = 0; b < 20; b++) {
/*  292 */         int m = PApplet.parseInt((param1Int1 + PApplet.parseInt((GuruQuest004.this.noise(PApplet.parseFloat(i) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) - 0.5F) * 2.0F * 70.0F)));
/*  293 */         int n = PApplet.parseInt((param1Int2 + PApplet.parseInt((GuruQuest004.this.noise(PApplet.parseFloat(j) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) - 0.5F) * 2.0F * 20.0F)));
/*  294 */         int i1 = PApplet.parseInt((20 + PApplet.parseInt(GuruQuest004.this.noise(PApplet.parseFloat(k) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) * 20.0F)));
/*  295 */         GuruQuest004.this.ellipse(m, n, i1, i1);
/*  296 */         i += 1000;
/*  297 */         j += 1000;
/*  298 */         k += 1000;
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   class GameText
/*      */   {
/*      */     String s;
/*      */     int x;
/*      */     int y;
/*      */     int inSpeed;
/*      */     int outSpeed;
/*      */     int gameTextFill;
/*  312 */     int gameTextAlpha = 255;
/*      */     int bg;
/*  314 */     int bgAlpha = 255;
/*      */     
/*      */     String align;
/*      */     PFont f;
/*      */     
/*      */     GameText(String param1String1, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, int param1Int7, String param1String2) {
/*  320 */       this.s = param1String1;
/*  321 */       this.x = param1Int1;
/*  322 */       this.y = param1Int2;
/*  323 */       this.bg = param1Int3;
/*  324 */       this.inSpeed = param1Int4;
/*  325 */       this.outSpeed = param1Int5;
/*  326 */       this.gameTextFill = param1Int6;
/*  327 */       this.gameTextAlpha = param1Int7;
/*  328 */       this.bgAlpha = param1Int7;
/*  329 */       this.align = param1String2;
/*  330 */       this.f = GuruQuest004.this.loadFont("Helvetica-14.vlw");
/*      */     }
/*      */ 
/*      */     
/*      */     public void display() {
/*  335 */       if (this.bg != -1) {
/*  336 */         GuruQuest004.this.noStroke();
/*  337 */         GuruQuest004.this.fill(this.bg, this.bgAlpha);
/*  338 */         GuruQuest004.this.rect(0.0F, 0.0F, GuruQuest004.this.width, GuruQuest004.this.height);
/*      */       } 
/*  340 */       GuruQuest004.this.textFont(this.f);
/*  341 */       GuruQuest004.this.textAlign(3);
/*  342 */       if (this.align.equals("left")) GuruQuest004.this.textAlign(37); 
/*  343 */       if (this.align.equals("right")) GuruQuest004.this.textAlign(39); 
/*  344 */       if (this.align.equals("center")) GuruQuest004.this.textAlign(3); 
/*  345 */       GuruQuest004.this.fill(this.gameTextFill, this.gameTextAlpha);
/*  346 */       GuruQuest004.this.text(this.s, this.x, this.y);
/*      */     }
/*      */     
/*      */     public void fadeOut() {
/*  350 */       this.bgAlpha = GuruQuest004.constrain(this.bgAlpha - this.outSpeed, 0, 255);
/*  351 */       this.gameTextAlpha = GuruQuest004.constrain(this.gameTextAlpha - this.outSpeed, 0, 255);
/*  352 */       display();
/*      */     }
/*      */     
/*      */     public void fadeIn() {
/*  356 */       this.bgAlpha = GuruQuest004.constrain(this.bgAlpha + this.inSpeed, 0, 255);
/*  357 */       this.gameTextAlpha = GuruQuest004.constrain(this.gameTextAlpha + this.inSpeed, 0, 255);
/*  358 */       display();
/*      */     }
/*      */     
/*      */     public boolean minAlpha() {
/*  362 */       return (this.bgAlpha == 0 && this.gameTextAlpha == 0);
/*      */     }
/*      */     
/*      */     public boolean maxAlpha() {
/*  366 */       return (this.bgAlpha == 255 && this.gameTextAlpha == 255);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class Guru
/*      */     extends Person
/*      */   {
/*  381 */     int OUTGURU_MAX = 3;
/*      */     
/*      */     Eliza guru;
/*      */     
/*      */     Eliza guruTest;
/*      */     
/*  387 */     int h = 5;
/*      */     
/*  389 */     String[] wouldSay = new String[] {
/*  390 */         "", "", "", "", "", "", "", "", "", ""
/*      */       };
/*  392 */     Boolean outGuruable = Boolean.valueOf(true);
/*  393 */     Boolean consulted = Boolean.valueOf(false);
/*      */     
/*  395 */     int outGuruCount = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Guru(PApplet param1PApplet, GuruQuest004.World param1World, int param1Int) {
/*  403 */       super(param1World, param1Int);
/*  404 */       this.guru = new Eliza(param1PApplet);
/*  405 */       this.guru.readScript("GuruScript.txt");
/*      */ 
/*      */       
/*  408 */       this.guruTest = new Eliza(param1PApplet);
/*  409 */       this.guruTest.readScript("GuruScript.txt");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void processInput(String param1String) {
/*  421 */       if (!param1String.equals("") && this.w.inConversationRange()) {
/*      */         
/*  423 */         this.consulted = Boolean.valueOf(true);
/*      */         
/*  425 */         this.sayText = this.guru.processInput(param1String);
/*  426 */         this.sayText = this.sayText.replaceAll("\\s \\.", ".");
/*  427 */         this.sayText = this.sayText.replaceAll("\\s ,", ",");
/*  428 */         this.sayText = this.sayText.replaceAll("\\s \\?", "?");
/*  429 */         this.sayText = this.sayText.replaceAll("  ", " ");
/*      */         
/*  431 */         if (this.outGuruable.booleanValue()) {
/*      */ 
/*      */ 
/*      */           
/*  435 */           for (byte b1 = 0; b1 < this.wouldSay.length; b1++) {
/*  436 */             String str1 = this.wouldSay[b1].toLowerCase();
/*  437 */             str1 = str1.replaceAll("\\W", "");
/*  438 */             String str2 = param1String.replaceAll("\\W", "");
/*  439 */             GuruQuest004.println("Would say: " + str1);
/*  440 */             GuruQuest004.println("Simple input: " + str2);
/*      */             
/*  442 */             if (str2.equals(str1)) {
/*      */ 
/*      */               
/*  445 */               this.sayText = "Wise words.";
/*  446 */               this.outGuruCount++;
/*  447 */               this.w.outGurued();
/*      */ 
/*      */               
/*  450 */               if (this.outGuruCount == this.OUTGURU_MAX) {
/*  451 */                 this.w.outGurued();
/*  452 */                 this.w.guruStatusAchieved();
/*      */               } 
/*      */               
/*  455 */               this.outGuruable = Boolean.valueOf(false);
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*      */           
/*  461 */           if (!this.sayText.equals("Wise words.")) {
/*  462 */             this.outGuruCount = 0;
/*      */           }
/*      */         } else {
/*      */           
/*  466 */           this.outGuruable = Boolean.valueOf(true);
/*      */         } 
/*      */ 
/*      */         
/*  470 */         for (byte b = 0; b < this.wouldSay.length; b++) {
/*  471 */           this.wouldSay[b] = this.guruTest.processInput(this.sayText);
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void display() {
/*  484 */       int i = this.w.getX(this.t);
/*  485 */       int j = this.w.getY(this.t) - 10;
/*      */ 
/*      */       
/*  488 */       GuruQuest004.this.stroke(255.0F, 0.0F, 0.0F);
/*  489 */       GuruQuest004.this.line(i, j, i, (j - 3));
/*  490 */       GuruQuest004.this.line((i - 1), j, (i + 1), j);
/*  491 */       GuruQuest004.this.line((i - 1), (j - 1), (i + 1), (j - 1));
/*      */       
/*  493 */       if (this.w.inConversationRange()) {
/*  494 */         super.display();
/*      */       } else {
/*      */         
/*  497 */         this.sayText = "";
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean consulted() {
/*  503 */       return this.consulted.booleanValue();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   class Hills
/*      */   {
/*  510 */     int TIME_INCREMENT = 5;
/*  511 */     int HILL_SHADOW_COLOUR = GuruQuest004.this.color(100, 100, 100);
/*      */     
/*      */     GuruQuest004.World w;
/*      */     
/*      */     int heightRange;
/*      */     int baseY;
/*      */     int c;
/*      */     
/*      */     Hills(GuruQuest004.World param1World, int param1Int1, int param1Int2, int param1Int3) {
/*  520 */       this.w = param1World;
/*  521 */       this.heightRange = param1Int1;
/*  522 */       this.baseY = param1Int2;
/*  523 */       this.c = param1Int3;
/*      */     }
/*      */ 
/*      */     
/*      */     public void display(int param1Int) {
/*  528 */       drawHills(param1Int);
/*  529 */       drawShadows(param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     public void drawHills(int param1Int) {
/*  534 */       int i = param1Int;
/*      */ 
/*      */ 
/*      */       
/*  538 */       GuruQuest004.this.noStroke();
/*  539 */       GuruQuest004.this.fill(this.c);
/*      */       
/*  541 */       int j = 0;
/*  542 */       byte b = 0;
/*  543 */       GuruQuest004.this.beginShape();
/*  544 */       while (b < GuruQuest004.this.width) {
/*  545 */         j = PApplet.parseInt(this.baseY + (GuruQuest004.this.noise(PApplet.parseFloat(i) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) - 0.5F) * this.heightRange);
/*  546 */         GuruQuest004.this.vertex(b, j);
/*  547 */         i += this.TIME_INCREMENT;
/*  548 */         b++;
/*      */       } 
/*      */       
/*  551 */       GuruQuest004.this.vertex((GuruQuest004.this.width + 1), j);
/*  552 */       GuruQuest004.this.vertex((GuruQuest004.this.width + 1), (GuruQuest004.this.height + 1));
/*  553 */       GuruQuest004.this.vertex(-1.0F, (GuruQuest004.this.height + 1));
/*  554 */       GuruQuest004.this.vertex(-1.0F, j);
/*  555 */       GuruQuest004.this.endShape();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void drawShadows(int param1Int) {
/*  561 */       byte b = 0;
/*  562 */       int i = param1Int;
/*  563 */       int j = PApplet.parseInt(this.baseY + (GuruQuest004.this.noise(PApplet.parseFloat(i) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) - 0.5F) * this.heightRange);
/*      */ 
/*      */       
/*  566 */       i += this.TIME_INCREMENT;
/*      */       
/*  568 */       while (b < GuruQuest004.this.width) {
/*  569 */         b++;
/*  570 */         int k = PApplet.parseInt(this.baseY + (GuruQuest004.this.noise(PApplet.parseFloat(i) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) - 0.5F) * this.heightRange);
/*      */         
/*  572 */         GuruQuest004.this.stroke(this.HILL_SHADOW_COLOUR);
/*  573 */         GuruQuest004.this.strokeWeight(1.0F);
/*      */         
/*  575 */         if (PApplet.parseInt(j) > PApplet.parseInt(k)) {
/*      */           
/*  577 */           int m = PApplet.parseInt(GuruQuest004.this.noise(PApplet.parseFloat(i) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) * 1000.0F % 15.0F);
/*  578 */           GuruQuest004.this.line((b + 1), (j + 1), (b + m), (j + m));
/*      */         } 
/*  580 */         i += this.TIME_INCREMENT;
/*  581 */         j = k;
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class House
/*      */   {
/*  591 */     int HOME_WIDTH = 20;
/*  592 */     int PUFF_CIRCLES = 10;
/*      */     
/*  594 */     int BRICK_COLOUR = GuruQuest004.this.color(150, 20, 10);
/*  595 */     int FOUNDATION_COLOUR = GuruQuest004.this.color(220, 220, 220);
/*  596 */     int ROOF_COLOUR = GuruQuest004.this.color(60, 60, 0);
/*  597 */     int TRIMMING_COLOUR = GuruQuest004.this.color(200);
/*  598 */     int LIGHTS_ON = GuruQuest004.this.color(250, 250, 100);
/*  599 */     int LIGHTS_OFF = GuruQuest004.this.color(50);
/*  600 */     int SMOKE_COLOUR = GuruQuest004.this.color(240, 30);
/*      */     
/*      */     GuruQuest004.World w;
/*      */     
/*      */     int t;
/*      */     boolean occupied;
/*      */     int smokeHeight;
/*      */     int smokeOffset;
/*      */     
/*      */     House(GuruQuest004.World param1World, int param1Int) {
/*  610 */       this.w = param1World;
/*  611 */       this.t = param1Int;
/*  612 */       this.occupied = true;
/*  613 */       this.smokeHeight = 0;
/*  614 */       this.smokeOffset = 0;
/*      */     }
/*      */ 
/*      */     
/*      */     public void tick() {}
/*      */ 
/*      */     
/*      */     public void display() {
/*  622 */       int i = this.w.getX(this.t);
/*  623 */       int j = this.w.getY(this.t);
/*      */       
/*  625 */       GuruQuest004.this.noStroke();
/*  626 */       GuruQuest004.this.rectMode(0);
/*      */ 
/*      */       
/*  629 */       GuruQuest004.this.fill(this.BRICK_COLOUR);
/*      */       
/*  631 */       GuruQuest004.this.rect((i - this.HOME_WIDTH / 2), (j - this.HOME_WIDTH), this.HOME_WIDTH, this.HOME_WIDTH);
/*      */       
/*  633 */       GuruQuest004.this.rect((i + this.HOME_WIDTH / 2 - 3), (j - this.HOME_WIDTH - this.HOME_WIDTH / 2), 3.0F, 60.0F);
/*  634 */       GuruQuest004.this.fill(this.FOUNDATION_COLOUR);
/*      */       
/*  636 */       GuruQuest004.this.rect((i - this.HOME_WIDTH / 2), j, this.HOME_WIDTH, this.HOME_WIDTH);
/*  637 */       GuruQuest004.this.fill(this.ROOF_COLOUR);
/*      */       
/*  639 */       GuruQuest004.this.triangle((i - this.HOME_WIDTH / 2 - 5), (j - this.HOME_WIDTH + 5), (i + this.HOME_WIDTH / 2 + 5), (j - this.HOME_WIDTH + 5), i, (j - this.HOME_WIDTH - this.HOME_WIDTH / 2));
/*      */       
/*  641 */       GuruQuest004.this.stroke(this.TRIMMING_COLOUR);
/*      */       
/*  643 */       GuruQuest004.this.rect((i - 2), (j - 10), 4.0F, 9.0F);
/*      */       
/*  645 */       if (this.occupied) {
/*  646 */         GuruQuest004.this.fill(this.LIGHTS_ON);
/*      */       } else {
/*      */         
/*  649 */         GuruQuest004.this.fill(this.LIGHTS_OFF);
/*      */       } 
/*  651 */       GuruQuest004.this.rect((i - 8), (j - 10), 3.0F, 3.0F);
/*  652 */       GuruQuest004.this.rect((i + 5), (j - 10), 3.0F, 3.0F);
/*      */       
/*  654 */       if (this.occupied || this.smokeOffset <= this.smokeHeight) {
/*  655 */         drawSmoke();
/*      */       } else {
/*      */         
/*  658 */         this.smokeHeight = 0;
/*      */       } 
/*      */     }
/*      */     
/*      */     public void drawWindows() {
/*  663 */       int i = this.w.getX(this.t);
/*  664 */       int j = this.w.getY(this.t);
/*  665 */       GuruQuest004.this.fill(this.LIGHTS_ON);
/*  666 */       GuruQuest004.this.rect((i - 8), (j - 10), 3.0F, 3.0F);
/*  667 */       GuruQuest004.this.rect((i + 5), (j - 10), 3.0F, 3.0F);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void drawSmoke() {
/*  673 */       int i = this.w.getX(this.t) + this.HOME_WIDTH / 2 - 2;
/*  674 */       int j = this.w.getY(this.t) - this.HOME_WIDTH - this.HOME_WIDTH / 2 - 5;
/*  675 */       GuruQuest004.this.noStroke();
/*  676 */       GuruQuest004.this.fill(this.SMOKE_COLOUR);
/*  677 */       for (int k = this.smokeOffset; k < this.smokeHeight; k++) {
/*  678 */         for (byte b = 0; b < this.PUFF_CIRCLES; b++) {
/*  679 */           int m = i + PApplet.parseInt(GuruQuest004.this.random(-2.0F, 2.0F));
/*  680 */           int n = j - k * 2 - PApplet.parseInt(GuruQuest004.this.random(-3.0F, 3.0F));
/*  681 */           int i1 = PApplet.parseInt(GuruQuest004.this.random((k / 10), (k / 6))) * 1 + 2;
/*  682 */           GuruQuest004.this.ellipse(m, n, i1, i1);
/*      */         } 
/*      */       } 
/*      */       
/*  686 */       this.smokeHeight = GuruQuest004.constrain(this.smokeHeight + 1, 0, j);
/*  687 */       if (!this.occupied) {
/*  688 */         this.smokeOffset = GuruQuest004.constrain(this.smokeOffset + 1, 0, this.smokeHeight);
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public void avatarEntered() {
/*  694 */       this.occupied = true;
/*  695 */       this.smokeHeight = 0;
/*  696 */       this.smokeOffset = 0;
/*      */     }
/*      */     
/*      */     public void avatarLeft() {
/*  700 */       this.occupied = false;
/*  701 */       this.smokeOffset = 0;
/*      */     }
/*      */     
/*      */     public int getT() {
/*  705 */       return this.t;
/*      */     }
/*      */     
/*      */     public int getX() {
/*  709 */       return this.w.getX(this.t);
/*      */     }
/*      */     
/*      */     public int getY() {
/*  713 */       return this.w.getY(this.t);
/*      */     }
/*      */     
/*      */     public boolean occupied() {
/*  717 */       return this.occupied;
/*      */     }
/*      */     
/*      */     public boolean inFront(int param1Int) {
/*  721 */       return (param1Int > this.w.getX(this.t) - this.HOME_WIDTH / 2 && param1Int < this.w.getX(this.t) + this.HOME_WIDTH / 2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class Pagoda
/*      */   {
/*  733 */     int PAGODA_BASE_WIDTH = 21;
/*      */     
/*      */     GuruQuest004.World w;
/*      */     int t;
/*      */     int tiers;
/*      */     
/*      */     Pagoda(GuruQuest004.World param1World, int param1Int) {
/*  740 */       this.w = param1World;
/*  741 */       this.t = param1Int;
/*  742 */       this.tiers = PApplet.parseInt(GuruQuest004.this.noise(PApplet.parseFloat(this.t) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) * 4.0F) + 4;
/*      */     }
/*      */ 
/*      */     
/*      */     public void display() {
/*  747 */       int i = this.w.getX(this.t);
/*  748 */       int j = this.w.getY(this.t);
/*      */       
/*  750 */       GuruQuest004.this.rectMode(3);
/*      */       
/*  752 */       for (byte b = 0; b < this.tiers; b++) {
/*  753 */         GuruQuest004.this.fill(30);
/*  754 */         GuruQuest004.this.stroke(30);
/*  755 */         GuruQuest004.this.rect(i, (j - b * 10), this.PAGODA_BASE_WIDTH, 10.0F);
/*  756 */         GuruQuest004.this.triangle((i - 15), (j - b * 10 - 2), (i + 15), (j - b * 10 - 2), i, (j - b * 10 - 12));
/*  757 */         if (b > 1) {
/*  758 */           GuruQuest004.this.stroke(150);
/*  759 */           GuruQuest004.this.line((i - (this.PAGODA_BASE_WIDTH - 1) / 2), (j - b * 10 - 2), (i + (this.PAGODA_BASE_WIDTH - 1) / 2), (j - b * 10 - 2));
/*  760 */           if (b > 2 && b < this.tiers) {
/*  761 */             GuruQuest004.this.rect(i, (j - (b - 1) * 10 - 6), 2.0F, 2.0F);
/*      */           }
/*  763 */           for (byte b1 = 1; b1 < 20; b1 += 2) {
/*  764 */             GuruQuest004.this.point((i - 10 + b1), (j - b * 10 - 1));
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/*  769 */       GuruQuest004.this.noStroke();
/*      */       
/*  771 */       GuruQuest004.this.triangle(i, (j - this.tiers * 10), (i - 3), (j - this.tiers * 10 - 3), (i + 3), (j - this.tiers * 10 - 3));
/*  772 */       GuruQuest004.this.triangle(i, (j - this.tiers * 10 - 6), (i - 3), (j - this.tiers * 10 - 3), (i + 3), (j - this.tiers * 10 - 3));
/*      */ 
/*      */ 
/*      */       
/*  776 */       GuruQuest004.this.stroke(150);
/*      */       
/*  778 */       GuruQuest004.this.line((i - 8), (j - 2), (i + 8), (j - 2));
/*  779 */       GuruQuest004.this.line((i - 6), (j - 4), (i + 6), (j - 4));
/*  780 */       GuruQuest004.this.line((i - 4), (j - 6), (i + 4), (j - 6));
/*  781 */       GuruQuest004.this.line((i - 2), (j - 8), (i + 2), (j - 8));
/*      */ 
/*      */       
/*  784 */       GuruQuest004.this.line((i - 6), (j - 4), (i - 6), (j - 18));
/*  785 */       GuruQuest004.this.line((i + 6), (j - 18), (i + 6), (j - 4));
/*      */     }
/*      */     
/*      */     public int getT() {
/*  789 */       return this.t;
/*      */     }
/*      */     
/*      */     public int getX() {
/*  793 */       return this.w.getX(this.t);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class Person
/*      */   {
/*      */     GuruQuest004.World w;
/*      */ 
/*      */ 
/*      */     
/*      */     int t;
/*      */ 
/*      */ 
/*      */     
/*  811 */     String sayText = "";
/*  812 */     String saidText = "";
/*  813 */     int sayTextLines = 1;
/*      */     float lineHeight;
/*  815 */     int charWidth = 10;
/*  816 */     int LINE_LENGTH = 15;
/*      */     
/*  818 */     int sayAlpha = 220;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     PFont font;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Person(GuruQuest004.World param1World, int param1Int) {
/*  829 */       this.w = param1World;
/*  830 */       this.t = param1Int;
/*  831 */       this.font = GuruQuest004.this.loadFont("Monospaced-14.vlw");
/*  832 */       this.lineHeight = GuruQuest004.this.textAscent() + GuruQuest004.this.textDescent() + 2.0F;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void display() {
/*  845 */       byte b1 = 0;
/*  846 */       String str = "";
/*  847 */       byte b2 = 0;
/*  848 */       byte b3 = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  853 */       for (byte b4 = 0; b4 < this.sayText.length(); b4++) {
/*  854 */         if (b1 > b3) {
/*  855 */           b3 = b1;
/*      */         }
/*  857 */         if (this.sayText.charAt(b4) == ' ' && b1 >= this.LINE_LENGTH) {
/*  858 */           str = String.valueOf(str) + this.sayText.substring(b4 - b1, b4) + '\n';
/*  859 */           b1 = 0;
/*  860 */           b2++;
/*      */         } 
/*  862 */         b1++;
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  867 */       str = String.valueOf(str) + this.sayText.substring(this.sayText.length() - b1, this.sayText.length());
/*  868 */       if (str.length() > 0) {
/*  869 */         drawBalloon(str, (b3 + 1), (b2 + 2));
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void drawBalloon(String param1String, float param1Float1, float param1Float2) {
/*  883 */       float f1 = this.w.getX(this.t);
/*  884 */       float f2 = this.w.getY(this.t);
/*      */ 
/*      */       
/*  887 */       GuruQuest004.this.fill(255.0F, 250.0F, 250.0F, this.sayAlpha);
/*  888 */       GuruQuest004.this.stroke(200.0F, 200.0F, 200.0F, this.sayAlpha);
/*      */ 
/*      */ 
/*      */       
/*  892 */       GuruQuest004.this.beginShape();
/*  893 */       GuruQuest004.this.vertex(f1, f2 - 20.0F);
/*  894 */       GuruQuest004.this.vertex(f1, f2 - 80.0F);
/*  895 */       GuruQuest004.this.vertex(f1 - param1Float1 * this.charWidth / 2.0F - 5.0F, f2 - 80.0F);
/*  896 */       GuruQuest004.this.vertex(f1 - param1Float1 * this.charWidth / 2.0F - 5.0F, f2 - 80.0F - param1Float2 * this.lineHeight);
/*  897 */       GuruQuest004.this.vertex(f1 + param1Float1 * this.charWidth / 2.0F + 5.0F, f2 - 80.0F - param1Float2 * this.lineHeight);
/*  898 */       GuruQuest004.this.vertex(f1 + param1Float1 * this.charWidth / 2.0F + 5.0F, f2 - 80.0F);
/*  899 */       GuruQuest004.this.vertex(f1 + 5.0F, f2 - 80.0F);
/*  900 */       GuruQuest004.this.vertex(f1, f2 - 20.0F);
/*  901 */       GuruQuest004.this.endShape();
/*      */ 
/*      */       
/*  904 */       GuruQuest004.this.fill(50, this.sayAlpha);
/*  905 */       GuruQuest004.this.textFont(this.font);
/*  906 */       GuruQuest004.this.textAlign(3);
/*  907 */       GuruQuest004.this.text(param1String.toUpperCase(), f1, f2 - 80.0F - (param1Float2 - 1.0F) * this.lineHeight + this.lineHeight / 2.0F);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String said() {
/*  918 */       if (this.saidText.length() > 0) {
/*  919 */         String str = this.saidText.substring(0, this.saidText.length());
/*  920 */         this.saidText = "";
/*  921 */         return str;
/*      */       } 
/*  923 */       return "";
/*      */     }
/*      */ 
/*      */     
/*      */     public int getT() {
/*  928 */       return this.t;
/*      */     }
/*      */     
/*      */     public int getX() {
/*  932 */       return this.w.getX(this.t);
/*      */     }
/*      */     
/*      */     public int getY() {
/*  936 */       return this.w.getY(this.t);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class SoundScape
/*      */   {
/*  949 */     AudioSnippet[] sounds = new AudioSnippet[12];
/*      */     Minim minim;
/*      */     
/*      */     SoundScape(PApplet param1PApplet) {
/*  953 */       this.minim = new Minim(param1PApplet);
/*  954 */       for (byte b = 0; b < 12; b++) {
/*  955 */         this.sounds[b] = this.minim.loadSnippet(String.valueOf(b + 1) + ".wav");
/*      */       }
/*      */     }
/*      */     
/*      */     public void tick() {
/*  960 */       if (GuruQuest004.this.frameCount % 50 == 0) {
/*  961 */         this.sounds[PApplet.parseInt(GuruQuest004.this.random(0.0F, 12.0F))].play(0);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   class Title
/*      */   {
/*  969 */     int TIME_INCREMENT = 5;
/*      */     
/*      */     GuruQuest004.World w;
/*      */     
/*      */     int heightRange;
/*      */     int baseY;
/*      */     int c;
/*      */     String title;
/*      */     PFont titleFont;
/*  978 */     int titleFill = 255;
/*  979 */     int titleAlpha = 0;
/*      */     
/*      */     int titleSpacing;
/*      */     int startT;
/*      */     int endT;
/*      */     
/*      */     Title(GuruQuest004.World param1World, int param1Int1, int param1Int2, String param1String, int param1Int3, int param1Int4) {
/*  986 */       this.w = param1World;
/*  987 */       this.heightRange = param1Int1;
/*  988 */       this.baseY = param1Int2;
/*  989 */       this.title = param1String;
/*      */       
/*  991 */       this.startT = param1Int3;
/*  992 */       this.endT = param1Int4;
/*  993 */       this.titleSpacing = PApplet.parseInt(((this.w.getX(this.endT) - this.w.getX(this.startT)) / this.title.length()));
/*      */       
/*  995 */       this.titleFont = GuruQuest004.this.loadFont("Helvetica-36.vlw");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void display(int param1Int) {
/* 1001 */       if (this.titleAlpha == 0) {
/*      */         return;
/*      */       }
/*      */       
/* 1005 */       GuruQuest004.this.textAlign(3);
/* 1006 */       GuruQuest004.this.textFont(this.titleFont);
/* 1007 */       GuruQuest004.this.fill(this.titleFill, this.titleAlpha);
/*      */       
/* 1009 */       int i = 0;
/* 1010 */       int j = 0;
/* 1011 */       param1Int = this.startT;
/*      */       
/* 1013 */       for (byte b = 0; b < this.title.length(); b++) {
/* 1014 */         j = this.w.getX(this.startT) + b * this.titleSpacing;
/* 1015 */         i = this.w.getY(param1Int);
/*      */         
/* 1017 */         GuruQuest004.this.text(this.title.charAt(b), j, i);
/*      */         
/* 1019 */         param1Int += this.TIME_INCREMENT * this.titleSpacing;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void fadeIn(int param1Int) {
/* 1028 */       display(param1Int);
/* 1029 */       this.titleAlpha = GuruQuest004.constrain(this.titleAlpha + 2, 0, 255);
/*      */     }
/*      */     
/*      */     public void fadeOut(int param1Int) {
/* 1033 */       display(param1Int);
/* 1034 */       this.titleAlpha = GuruQuest004.constrain(this.titleAlpha - 5, 0, 255);
/*      */     }
/*      */     
/*      */     public boolean fullAlpha() {
/* 1038 */       return (this.titleAlpha == 255);
/*      */     }
/*      */     
/*      */     public boolean minAlpha() {
/* 1042 */       return (this.titleAlpha == 0);
/*      */     }
/*      */   }
/*      */   
/*      */   class Trees
/*      */   {
/* 1048 */     int TIME_INCREMENT = 5;
/* 1049 */     int TREE_MAX_DELAY = 5;
/*      */     
/*      */     GuruQuest004.World w;
/*      */     
/*      */     int heightRange;
/*      */     int baseY;
/*      */     int treeDelay;
/*      */     
/*      */     Trees(GuruQuest004.World param1World, int param1Int1, int param1Int2) {
/* 1058 */       this.w = param1World;
/* 1059 */       this.heightRange = param1Int1;
/* 1060 */       this.baseY = param1Int2;
/* 1061 */       this.treeDelay = 0;
/*      */     }
/*      */ 
/*      */     
/*      */     public void display(int param1Int) {
/* 1066 */       int i = param1Int - 100;
/* 1067 */       int j = this.w.getX(i);
/*      */ 
/*      */       
/* 1070 */       while (j < GuruQuest004.this.width + 100) {
/*      */         
/* 1072 */         int k = PApplet.parseInt(this.baseY + (GuruQuest004.this.noise(PApplet.parseFloat(i) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) - 0.5F) * this.heightRange);
/*      */ 
/*      */         
/* 1075 */         if (PApplet.parseInt(GuruQuest004.this.noise(PApplet.parseFloat(i) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) * 1000.0F) % 15 == 0) {
/*      */           
/* 1077 */           int m = PApplet.parseInt(GuruQuest004.this.noise(PApplet.parseFloat(i) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) * 5.0F + 10.0F);
/*      */ 
/*      */           
/* 1080 */           GuruQuest004.this.stroke(100.0F, 80.0F, 50.0F);
/* 1081 */           GuruQuest004.this.line(j, k, j, (k - m));
/*      */ 
/*      */           
/* 1084 */           GuruQuest004.this.stroke(50.0F, 100.0F, 50.0F);
/* 1085 */           for (int n = k - m; n < k - 3; n += 2) {
/* 1086 */             GuruQuest004.this.line(j, n, (j - 3), (n + 3));
/* 1087 */             GuruQuest004.this.line(j, n, (j + 3), (n + 3));
/*      */           } 
/*      */ 
/*      */           
/* 1091 */           this.treeDelay = this.TREE_MAX_DELAY;
/*      */         }
/* 1093 */         else if (this.treeDelay != 0) {
/*      */           
/* 1095 */           this.treeDelay--;
/*      */         } 
/*      */ 
/*      */         
/* 1099 */         i += this.TIME_INCREMENT;
/* 1100 */         j++;
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   class World
/*      */   {
/*      */     boolean guruStatusAchieved = false;
/*      */     
/*      */     boolean endGame = false;
/*      */     
/*      */     boolean startGame = true;
/*      */     
/*      */     boolean fadeToGame = false;
/*      */     
/*      */     boolean preGame = false;
/*      */     
/*      */     boolean playGame = false;
/*      */     
/*      */     boolean creditsDisplay = false;
/*      */     
/*      */     GuruQuest004.Avatar avatar;
/*      */     
/*      */     GuruQuest004.Guru guru;
/*      */     
/*      */     GuruQuest004.Clouds clouds;
/*      */     
/*      */     GuruQuest004.House house;
/*      */     GuruQuest004.Pagoda pagoda;
/*      */     GuruQuest004.Hills foregroundHills;
/*      */     GuruQuest004.Hills paralaxHills;
/*      */     GuruQuest004.Trees trees;
/*      */     GuruQuest004.Title title;
/*      */     GuruQuest004.GameText introduction;
/*      */     GuruQuest004.GameText leavingInstructions;
/*      */     GuruQuest004.GameText instructions;
/*      */     GuruQuest004.GameText blackScreen;
/*      */     GuruQuest004.GameText credits;
/* 1139 */     final int TERRAIN_HEIGHT = 150;
/*      */     final int TERRAIN_BASE_Y;
/* 1141 */     final int PARALAX_HEIGHT = 200;
/* 1142 */     final int PARALAX_OFFSET = 50000;
/* 1143 */     final int PARALAX_TIME_RATIO = 2;
/*      */     
/*      */     final int PARALAX_BASE_Y;
/* 1146 */     final int HOME_T = 1500;
/*      */     
/* 1148 */     final int SCROLL_BOUNDARY = 200;
/*      */     
/* 1150 */     final int GROUND_COLOUR = GuruQuest004.this.color(150, 150, 160);
/* 1151 */     final int PARALAX_COLOUR = GuruQuest004.this.color(180, 180, 190);
/* 1152 */     int SKY_COLOUR = GuruQuest004.this.color(200, 200, 250);
/* 1153 */     int DUSK_COLOUR = GuruQuest004.this.color(100, 100, 120);
/*      */ 
/*      */ 
/*      */     
/* 1157 */     final int TIME_INCREMENT = 5;
/*      */ 
/*      */     
/*      */     int t;
/*      */ 
/*      */     
/*      */     int cloudT;
/*      */ 
/*      */     
/* 1166 */     int cloudDelay = 0;
/* 1167 */     int CLOUD_DELAY = 200;
/*      */     
/*      */     int insightFlashAlpha;
/*      */     
/*      */     int endGameAlpha;
/*      */     
/* 1173 */     int treeDelay = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     World(PApplet param1PApplet) {
/* 1183 */       this.TERRAIN_BASE_Y = 2 * GuruQuest004.this.height / 3;
/* 1184 */       this.PARALAX_BASE_Y = this.TERRAIN_BASE_Y - GuruQuest004.this.height / 6;
/*      */       
/* 1186 */       this.t = 0;
/* 1187 */       this.cloudT = 1000;
/*      */       
/* 1189 */       this.insightFlashAlpha = 0;
/* 1190 */       this.endGameAlpha = 0;
/*      */       
/* 1192 */       this.avatar = new GuruQuest004.Avatar(this, PApplet.parseInt(GuruQuest004.this.random(1500.0F, 1500.0F)));
/* 1193 */       this.guru = new GuruQuest004.Guru(param1PApplet, this, PApplet.parseInt(GuruQuest004.this.random(5000.0F, 5000.0F)));
/* 1194 */       this.clouds = new GuruQuest004.Clouds();
/* 1195 */       this.house = new GuruQuest004.House(this, 1500);
/* 1196 */       this.pagoda = new GuruQuest004.Pagoda(this, 5000);
/* 1197 */       this.foregroundHills = new GuruQuest004.Hills(this, 150, this.TERRAIN_BASE_Y, this.GROUND_COLOUR);
/* 1198 */       this.paralaxHills = new GuruQuest004.Hills(this, 200, this.PARALAX_BASE_Y, this.PARALAX_COLOUR);
/* 1199 */       this.trees = new GuruQuest004.Trees(this, 150, this.TERRAIN_BASE_Y);
/* 1200 */       this.title = new GuruQuest004.Title(this, 150, this.TERRAIN_BASE_Y, "GURUQUEST", this.house.getT() + 250, this.pagoda.getT() + 150);
/*      */       
/* 1202 */       String str1 = "YOU'VE HEARD TELL OF A GURU TO THE EAST.\nWILL YOU SEEK THE GURU?\nOR WILL YOU SEEK TO BE THE GURU?";
/* 1203 */       this.introduction = new GuruQuest004.GameText(str1, GuruQuest004.this.width / 2, GuruQuest004.this.height / 4, GuruQuest004.this.color(75, 80, 90), 10, 5, 200, 255, "center");
/*      */       
/* 1205 */       String str2 = "";
/* 1206 */       str2 = String.valueOf(str2) + "↓ TO LEAVE HOME\n";
/* 1207 */       this.leavingInstructions = new GuruQuest004.GameText(str2, this.house.getX(), this.house.getY() - 100, -1, 15, 15, 0, 0, "center");
/*      */       
/* 1209 */       String str3 = "";
/* 1210 */       str3 = String.valueOf(str3) + "TYPE TO TALK\n";
/* 1211 */       str3 = String.valueOf(str3) + "→ AND ← TO WALK\n";
/* 1212 */       str3 = String.valueOf(str3) + "↑ TO RETURN HOME\n";
/* 1213 */       str3 = String.valueOf(str3) + "AFTER YOUR QUEST\n";
/* 1214 */       this.instructions = new GuruQuest004.GameText(str3, this.house.getX(), this.house.getY() - 100, -1, 15, 15, 0, 0, "center");
/*      */       
/* 1216 */       this.blackScreen = new GuruQuest004.GameText("", 0, 0, 0, 1, 0, 0, 0, "left");
/*      */       
/* 1218 */       String str4 = "BY S-R";
/* 1219 */       this.credits = new GuruQuest004.GameText(str4, this.pagoda.getX(), GuruQuest004.this.height / 2 + 150, -1, 5, 0, 200, 0, "right");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void tick() {
/* 1229 */       if (this.startGame) {
/* 1230 */         GuruQuest004.this.background(0);
/* 1231 */         this.introduction.display();
/* 1232 */         if (GuruQuest004.this.frameCount > 30) {
/* 1233 */           this.title.fadeIn(this.t);
/*      */         }
/* 1235 */         if (this.title.fullAlpha()) {
/* 1236 */           this.startGame = false;
/* 1237 */           this.fadeToGame = true;
/*      */         }
/*      */       
/*      */       }
/* 1241 */       else if (this.fadeToGame) {
/* 1242 */         display();
/* 1243 */         this.introduction.fadeOut();
/* 1244 */         this.title.display(this.t);
/* 1245 */         this.clouds.tick();
/* 1246 */         if (this.introduction.minAlpha()) {
/* 1247 */           this.fadeToGame = false;
/* 1248 */           this.preGame = true;
/*      */         }
/*      */       
/*      */       }
/* 1252 */       else if (this.preGame) {
/* 1253 */         display();
/* 1254 */         this.clouds.tick();
/* 1255 */         this.house.tick();
/* 1256 */         if (!this.title.minAlpha()) {
/* 1257 */           this.title.fadeOut(this.t);
/*      */         } else {
/*      */           
/* 1260 */           this.leavingInstructions.fadeIn();
/*      */         }
/*      */       
/*      */       }
/* 1264 */       else if (this.playGame) {
/* 1265 */         if (GuruQuest004.this.frameCount > GuruQuest004.this.frameRate * 600.0F) fadeToDusk(); 
/* 1266 */         display();
/* 1267 */         this.clouds.tick();
/* 1268 */         this.house.tick();
/* 1269 */         if (!this.leavingInstructions.minAlpha()) {
/* 1270 */           this.leavingInstructions.fadeOut();
/*      */         }
/* 1272 */         else if (this.house.inFront(this.avatar.getX())) {
/* 1273 */           this.instructions.fadeIn();
/*      */         }
/* 1275 */         else if (!this.instructions.minAlpha()) {
/* 1276 */           this.instructions.fadeOut();
/*      */         } 
/* 1278 */         this.guru.processInput(this.avatar.said());
/*      */       
/*      */       }
/* 1281 */       else if (this.endGame) {
/* 1282 */         this.clouds.tick();
/* 1283 */         this.house.tick();
/* 1284 */         display();
/* 1285 */         scrollToStart();
/*      */       
/*      */       }
/* 1288 */       else if (this.creditsDisplay) {
/*      */ 
/*      */         
/* 1291 */         display();
/* 1292 */         if (!this.blackScreen.maxAlpha()) {
/* 1293 */           this.clouds.tick();
/* 1294 */           this.house.tick();
/*      */         } 
/*      */         
/* 1297 */         this.blackScreen.fadeIn();
/* 1298 */         this.title.fadeIn(this.t);
/*      */         
/* 1300 */         if (this.blackScreen.maxAlpha()) {
/* 1301 */           this.credits.fadeIn();
/*      */         }
/*      */         
/* 1304 */         if (this.house.occupied()) {
/* 1305 */           this.house.drawWindows();
/*      */         }
/* 1307 */         else if (this.avatar.guruStatus()) {
/* 1308 */           this.avatar.display();
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void display() {
/* 1319 */       GuruQuest004.this.background(this.SKY_COLOUR);
/*      */       
/* 1321 */       this.paralaxHills.display((this.t + 50000) / 2);
/*      */       
/* 1323 */       this.trees.display(this.t);
/*      */       
/* 1325 */       if (onScreen(this.pagoda.getT())) {
/* 1326 */         this.pagoda.display();
/*      */       }
/* 1328 */       if (onScreen(this.house.getT())) {
/* 1329 */         this.house.display();
/*      */       }
/* 1331 */       this.foregroundHills.display(this.t);
/*      */       
/* 1333 */       this.clouds.display();
/*      */       
/* 1335 */       if (this.insightFlashAlpha != 0) {
/* 1336 */         GuruQuest004.this.fill(255, this.insightFlashAlpha);
/* 1337 */         GuruQuest004.this.noStroke();
/* 1338 */         GuruQuest004.this.rect(0.0F, 0.0F, GuruQuest004.this.width, GuruQuest004.this.height);
/* 1339 */         this.insightFlashAlpha = GuruQuest004.constrain(this.insightFlashAlpha - 30, 0, 255);
/*      */       } 
/*      */       
/* 1342 */       if (!this.guruStatusAchieved) {
/* 1343 */         this.guru.display();
/*      */       }
/* 1345 */       this.avatar.display();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void outGurued() {
/* 1357 */       this.insightFlashAlpha = 255;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void guruStatusAchieved() {
/* 1366 */       this.guruStatusAchieved = true;
/* 1367 */       this.avatar.becomeGuru(this.guru.getT());
/* 1368 */       endGame();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getX(int param1Int) {
/* 1374 */       return PApplet.parseInt(((param1Int - this.t) / 5));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getY(int param1Int) {
/* 1381 */       return PApplet.parseInt(this.TERRAIN_BASE_Y + (GuruQuest004.this.noise(PApplet.parseFloat(param1Int) / PApplet.parseFloat(GuruQuest004.this.T_RATIO)) - 0.5F) * 150.0F);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean onScreen(int param1Int) {
/* 1391 */       return (getX(param1Int) > -100 && getX(param1Int) < GuruQuest004.this.width + 100);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void avatarMoved(int param1Int1, int param1Int2) {
/* 1400 */       getX(param1Int1);
/*      */ 
/*      */       
/* 1403 */       getX(param1Int1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean inConversationRange() {
/* 1411 */       if (getX(this.guru.getT()) > getX(this.avatar.getT()) - 200 && 
/* 1412 */         getX(this.guru.getT()) < getX(this.avatar.getT()) + 200) return true; 
/*      */       return false;
/*      */     }
/*      */     public void endGame() {
/* 1416 */       this.endGame = true;
/* 1417 */       this.playGame = false;
/* 1418 */       this.endGameAlpha = 0;
/*      */     }
/*      */     
/*      */     public void fadeToDusk() {
/* 1422 */       if (GuruQuest004.this.frameCount % 20 == 0) {
/* 1423 */         float f1 = GuruQuest004.this.red(this.SKY_COLOUR);
/* 1424 */         float f2 = GuruQuest004.this.green(this.SKY_COLOUR);
/* 1425 */         float f3 = GuruQuest004.this.blue(this.SKY_COLOUR);
/* 1426 */         if (f1 != GuruQuest004.this.red(this.DUSK_COLOUR)) f1--; 
/* 1427 */         if (f2 != GuruQuest004.this.green(this.DUSK_COLOUR)) f2--; 
/* 1428 */         if (f3 != GuruQuest004.this.blue(this.DUSK_COLOUR)) f3--; 
/* 1429 */         this.SKY_COLOUR = GuruQuest004.this.color(f1, f2, f3);
/*      */       } 
/*      */     }
/*      */     
/*      */     public void scrollToStart() {
/* 1434 */       if (this.t > 0) {
/* 1435 */         this.t -= 10;
/*      */       }
/* 1437 */       else if (this.t < 0) {
/* 1438 */         this.t += 10;
/*      */       }
/* 1440 */       else if (this.t == 0) {
/* 1441 */         this.endGame = false;
/* 1442 */         this.creditsDisplay = true;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void keyPressed() {
/* 1448 */       if (GuruQuest004.this.keyCode == 40 && this.avatar.atHome && this.preGame) {
/* 1449 */         this.avatar.atHome = false;
/* 1450 */         this.house.avatarLeft();
/* 1451 */         this.preGame = false;
/* 1452 */         this.playGame = true;
/*      */       }
/* 1454 */       else if (GuruQuest004.this.keyCode == 38 && !this.avatar.atHome && this.house.inFront(this.avatar.getX()) && this.guru.consulted()) {
/* 1455 */         this.avatar.atHome = true;
/* 1456 */         this.house.avatarEntered();
/* 1457 */         endGame();
/*      */       }
/*      */       else {
/*      */         
/* 1461 */         this.avatar.keyPressed();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void keyReleased() {
/* 1467 */       this.avatar.keyReleased();
/*      */     }
/*      */   }
/*      */   
/*      */   public static void main(String[] paramArrayOfString) {
/* 1472 */     PApplet.main(new String[] { "--present", "--bgcolor=#666666", "--hide-stop", "GuruQuest004" });
/*      */   }
/*      */ }


/* Location:              /Users/pippinbarr/Dropbox/Develop/Processing/GuruQuest for Mac OS X/GuruQuest004.jar!/GuruQuest004.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */