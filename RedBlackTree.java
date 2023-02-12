/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Queue;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RedBlackTree
/*     */ {
/*     */   private RedBlackNode root;
/*     */   
/*     */   public void add(RedBlackNode x) {
/*  13 */     this.root = add(this.root, x);
/*  14 */     this.root.setColor(ColorNode.BLACK);
/*     */   }
/*     */   
/*     */   private RedBlackNode add(RedBlackNode iter, RedBlackNode x) {
/*  18 */     if (iter == null || iter.getValue() == null) {
/*  19 */       return x;
/*     */     }
/*  21 */     if (iter.getColor() == ColorNode.BLACK && iter.getLeft().getColor() == ColorNode.RED && iter.getRight().getColor() == ColorNode.RED) {
/*     */       
/*  23 */       iter.setColor(ColorNode.RED);
/*  24 */       iter.getLeft().setColor(ColorNode.BLACK);
/*  25 */       iter.getRight().setColor(ColorNode.BLACK);
/*     */     } 
/*     */     
/*  28 */     int dir = x.getValue().compareTo(iter.getValue());
/*  29 */     if (dir < 0) {
/*  30 */       iter.setLeft(add(iter.getLeft(), x));
/*  31 */     } else if (dir > 0) {
/*  32 */       iter.setRight(add(iter.getRight(), x));
/*     */     } 
/*  34 */     if (leftRight(iter)) {
/*     */       
/*  36 */       iter.setLeft(rotateLeft(iter.getLeft(), iter.getLeft().getRight()));
/*  37 */       iter = rotateRight(iter, iter.getLeft());
/*  38 */       iter.getRight().setColor(ColorNode.RED);
/*  39 */       iter.setColor(ColorNode.BLACK);
/*     */     }
/*  41 */     else if (rightLeft(iter)) {
/*     */       
/*  43 */       iter.setRight(rotateRight(iter.getRight(), iter.getRight().getLeft()));
/*  44 */       iter = rotateLeft(iter, iter.getRight());
/*  45 */       iter.getLeft().setColor(ColorNode.RED);
/*  46 */       iter.setColor(ColorNode.BLACK);
/*     */     }
/*  48 */     else if (leftLeft(iter)) {
/*     */       
/*  50 */       iter = rotateRight(iter, iter.getLeft());
/*  51 */       iter.getRight().setColor(ColorNode.RED);
/*  52 */       iter.setColor(ColorNode.BLACK);
/*     */     }
/*  54 */     else if (rightRight(iter)) {
/*     */       
/*  56 */       iter = rotateLeft(iter, iter.getRight());
/*  57 */       iter.getLeft().setColor(ColorNode.RED);
/*  58 */       iter.setColor(ColorNode.BLACK);
/*     */     } 
/*     */     
/*  61 */     return iter;
/*     */   }
/*     */   
/*     */   public RedBlackNode remove(Comparable x) {
/*  65 */     if (getNode(this.root, x) == null)
/*  66 */       return null; 
/*  67 */     RedBlackNode temp = getNode(this.root, x);
/*  68 */     ColorNode color = temp.getColor();
/*  69 */     if (temp.getLeft().getValue() == null && temp.getRight().getValue() == null) {
/*  70 */       color = temp.getColor();
/*  71 */     } else if (temp.getLeft().getValue() == null) {
/*  72 */       color = maxNode(temp.getRight()).getColor();
/*     */     } else {
/*  74 */       color = maxNode(temp.getLeft()).getColor();
/*  75 */     }  this.root = remove(this.root, x);
/*  76 */     this.root.setColor(ColorNode.BLACK);
/*  77 */     RedBlackNode rtn = new RedBlackNode(x);
/*  78 */     rtn.setColor(color);
/*  79 */     return rtn;
/*     */   }
/*     */   
/*     */   private RedBlackNode remove(RedBlackNode iter, Comparable<Comparable> x) {
/*  83 */     if (iter == null || iter.getValue() == null)
/*  84 */       return null; 
/*  85 */     int dir = x.compareTo(iter.getValue());
/*  86 */     if (dir < 0) {
/*  87 */       iter.setLeft(remove(iter.getLeft(), x));
/*  88 */     } else if (dir > 0) {
/*  89 */       iter.setRight(remove(iter.getRight(), x));
/*     */     } else {
/*     */       
/*  92 */       if (iter.getLeft().getValue() == null) {
/*     */         
/*  94 */         if (iter.getColor() == ColorNode.BLACK && iter.getRight().getColor() == ColorNode.RED) {
/*  95 */           iter.getRight().setColor(ColorNode.BLACK);
/*  96 */         } else if (iter.getColor() == ColorNode.BLACK && iter.getRight().getColor() == ColorNode.BLACK) {
/*  97 */           iter.getRight().setColor(ColorNode.DOUBLE_BLACK);
/*  98 */         }  return iter.getRight();
/*     */       } 
/* 100 */       if (iter.getRight().getValue() == null) {
/*     */         
/* 102 */         if (iter.getColor() == ColorNode.BLACK && iter.getLeft().getColor() == ColorNode.RED) {
/* 103 */           iter.getLeft().setColor(ColorNode.BLACK);
/* 104 */         } else if (iter.getColor() == ColorNode.BLACK && iter.getLeft().getColor() == ColorNode.BLACK) {
/* 105 */           iter.getLeft().setColor(ColorNode.DOUBLE_BLACK);
/* 106 */         }  return iter.getLeft();
/*     */       } 
/* 108 */       iter.setValue(maxValue(iter.getLeft()));
/* 109 */       iter.setLeft(remove(iter.getLeft(), iter.getValue()));
/*     */     } 
/*     */     
/* 112 */     if (iter.getLeft().getColor() == ColorNode.DOUBLE_BLACK) {
/*     */       
/* 114 */       iter.getLeft().setColor(ColorNode.BLACK);
/* 115 */       if (iter.getRight().getRight().getColor() == ColorNode.RED) {
/*     */         
/* 117 */         iter = rotateLeft(iter, iter.getRight());
/* 118 */         iter.getRight().setColor(iter.getColor());
/* 119 */         iter.setColor(iter.getLeft().getColor());
/* 120 */         iter.getLeft().setColor(ColorNode.BLACK);
/*     */       }
/* 122 */       else if (iter.getRight().getLeft().getColor() == ColorNode.RED) {
/*     */         
/* 124 */         iter.setRight(rotateRight(iter.getRight(), iter.getRight().getLeft()));
/* 125 */         iter.getRight().setColor(ColorNode.BLACK);
/* 126 */         iter = rotateLeft(iter, iter.getRight());
/* 127 */         iter.getRight().setColor(iter.getColor());
/* 128 */         iter.setColor(iter.getLeft().getColor());
/* 129 */         iter.getLeft().setColor(ColorNode.BLACK);
/*     */       }
/* 131 */       else if (iter.getRight().getColor() == ColorNode.BLACK) {
/*     */         
/* 133 */         iter.getLeft().setColor(ColorNode.BLACK);
/* 134 */         iter.getRight().setColor(ColorNode.RED);
/* 135 */         if (iter.getColor() == ColorNode.RED) {
/* 136 */           iter.setColor(ColorNode.BLACK);
/*     */         } else {
/* 138 */           iter.setColor(ColorNode.DOUBLE_BLACK);
/*     */         } 
/*     */       } else {
/*     */         
/* 142 */         iter = rotateLeft(iter, iter.getRight());
/* 143 */         iter.setColor(ColorNode.BLACK);
/* 144 */         iter.getLeft().setColor(ColorNode.BLACK);
/* 145 */         iter.getLeft().getLeft().setColor(ColorNode.BLACK);
/* 146 */         iter.getLeft().getRight().setColor(ColorNode.RED);
/*     */       }
/*     */     
/* 149 */     } else if (iter.getRight().getColor() == ColorNode.DOUBLE_BLACK) {
/*     */       
/* 151 */       iter.getRight().setColor(ColorNode.BLACK);
/* 152 */       if (iter.getLeft().getLeft().getColor() == ColorNode.RED) {
/*     */         
/* 154 */         iter = rotateRight(iter, iter.getLeft());
/* 155 */         iter.getLeft().setColor(iter.getColor());
/* 156 */         iter.setColor(iter.getRight().getColor());
/* 157 */         iter.getRight().setColor(ColorNode.BLACK);
/*     */       }
/* 159 */       else if (iter.getLeft().getRight().getColor() == ColorNode.RED) {
/*     */         
/* 161 */         iter.setLeft(rotateLeft(iter.getLeft(), iter.getLeft().getRight()));
/* 162 */         iter.getLeft().setColor(ColorNode.BLACK);
/* 163 */         iter = rotateRight(iter, iter.getLeft());
/* 164 */         iter.getLeft().setColor(iter.getColor());
/* 165 */         iter.setColor(iter.getRight().getColor());
/* 166 */         iter.getRight().setColor(ColorNode.BLACK);
/*     */       }
/* 168 */       else if (iter.getLeft().getColor() == ColorNode.BLACK) {
/*     */         
/* 170 */         iter.getRight().setColor(ColorNode.BLACK);
/* 171 */         iter.getLeft().setColor(ColorNode.RED);
/* 172 */         if (iter.getColor() == ColorNode.RED) {
/* 173 */           iter.setColor(ColorNode.BLACK);
/*     */         } else {
/* 175 */           iter.setColor(ColorNode.DOUBLE_BLACK);
/*     */         } 
/*     */       } else {
/*     */         
/* 179 */         iter = rotateRight(iter, iter.getLeft());
/* 180 */         iter.setColor(ColorNode.BLACK);
/* 181 */         iter.getRight().setColor(ColorNode.BLACK);
/* 182 */         iter.getRight().getRight().setColor(ColorNode.BLACK);
/* 183 */         iter.getRight().getLeft().setColor(ColorNode.RED);
/*     */       } 
/*     */     } 
/*     */     
/* 187 */     return iter;
/*     */   }
/*     */ 
/*     */   
/*     */   public RedBlackNode rotateLeft(RedBlackNode p, RedBlackNode c) {
/* 192 */     RedBlackNode temp = c.getLeft();
/* 193 */     c.setLeft(p);
/* 194 */     p.setRight(temp);
/* 195 */     return c;
/*     */   }
/*     */   
/*     */   public RedBlackNode rotateRight(RedBlackNode p, RedBlackNode c) {
/* 199 */     RedBlackNode temp = c.getRight();
/* 200 */     c.setRight(p);
/* 201 */     p.setLeft(temp);
/* 202 */     return c;
/*     */   }
/*     */   
/*     */   public boolean leftRight(RedBlackNode x) {
/* 206 */     if (x.getLeft().getValue() == null || x.getLeft().getRight().getValue() == null)
/* 207 */       return false; 
/* 208 */     if (x.getColor() == ColorNode.BLACK && x.getLeft().getColor() == ColorNode.RED && x.getLeft().getRight().getColor() == ColorNode.RED)
/* 209 */       return true; 
/* 210 */     return false;
/*     */   }
/*     */   
/*     */   public boolean rightLeft(RedBlackNode x) {
/* 214 */     if (x.getRight().getValue() == null || x.getRight().getLeft().getValue() == null)
/* 215 */       return false; 
/* 216 */     if (x.getColor() == ColorNode.BLACK && x.getRight().getColor() == ColorNode.RED && x.getRight().getLeft().getColor() == ColorNode.RED)
/* 217 */       return true; 
/* 218 */     return false;
/*     */   }
/*     */   
/*     */   public boolean leftLeft(RedBlackNode x) {
/* 222 */     if (x.getLeft().getValue() == null || x.getLeft().getLeft().getValue() == null)
/* 223 */       return false; 
/* 224 */     if (x.getColor() == ColorNode.BLACK && x.getLeft().getColor() == ColorNode.RED && x.getLeft().getLeft().getColor() == ColorNode.RED)
/* 225 */       return true; 
/* 226 */     return false;
/*     */   }
/*     */   
/*     */   public boolean rightRight(RedBlackNode x) {
/* 230 */     if (x.getRight().getValue() == null || x.getRight().getRight().getValue() == null)
/* 231 */       return false; 
/* 232 */     if (x.getColor() == ColorNode.BLACK && x.getRight().getColor() == ColorNode.RED && x.getRight().getRight().getColor() == ColorNode.RED)
/* 233 */       return true; 
/* 234 */     return false;
/*     */   }
/*     */   
/*     */   public Comparable minValue(RedBlackNode tree) {
/* 238 */     if (tree.getLeft().getValue() == null)
/* 239 */       return tree.getValue(); 
/* 240 */     return minValue(tree.getLeft());
/*     */   }
/*     */   
/*     */   public Comparable maxValue(RedBlackNode tree) {
/* 244 */     if (tree.getRight().getValue() == null)
/* 245 */       return tree.getValue(); 
/* 246 */     return maxValue(tree.getRight());
/*     */   }
/*     */   
/*     */   public RedBlackNode minNode(RedBlackNode tree) {
/* 250 */     if (tree.getLeft().getValue() == null)
/* 251 */       return tree; 
/* 252 */     return minNode(tree.getLeft());
/*     */   }
/*     */   
/*     */   public RedBlackNode maxNode(RedBlackNode tree) {
/* 256 */     if (tree.getRight().getValue() == null)
/* 257 */       return tree; 
/* 258 */     return maxNode(tree.getRight());
/*     */   }
/*     */   
/*     */   public int getNumLevels() {
/* 262 */     return getNumLevels(this.root);
/*     */   }
/*     */   
/*     */   private int getNumLevels(RedBlackNode tree) {
/* 266 */     if (tree.getValue() == null)
/* 267 */       return 0; 
/* 268 */     return 1 + Math.max(getNumLevels(tree.getLeft()), getNumLevels(tree.getRight()));
/*     */   }
/*     */   
/*     */   public void printFullTree(String x, int lvl) {
/* 272 */     String[] levels = x.split(",");
/* 273 */     for (int i = 0; i < lvl; i++) {
/*     */       
/* 275 */       String[] nodes = levels[i].split(" ");
/* 276 */       for (String node : nodes)
/* 277 */         System.out.print(node + "|"); 
/* 278 */       System.out.println();
/*     */     } 
/*     */   }
/*     */   
/*     */   public String fullLevelOrder() {
/* 283 */     String rtn = "";
/* 284 */     int lvl = getNumLevels(this.root);
/* 285 */     for (int i = 0; i < lvl; i++) {
/*     */       
/* 287 */       rtn = rtn + rtn;
/* 288 */       rtn = rtn + ",";
/*     */     } 
/* 290 */     return rtn;
/*     */   }
/*     */   
/*     */   public String fullLevelOrder(int lvl) {
/* 294 */     String rtn = "";
/* 295 */     for (int i = 0; i < lvl; i++) {
/*     */       
/* 297 */       rtn = rtn + rtn;
/* 298 */       rtn = rtn + ",";
/*     */     } 
/* 300 */     return rtn;
/*     */   }
/*     */   
/*     */   private String fullLevelOrder(RedBlackNode tree, int lvl) {
/* 304 */     if (tree == null && lvl > 0)
/* 305 */       return fullLevelOrder(null, lvl - 1) + fullLevelOrder(null, lvl - 1); 
/* 306 */     if (tree == null && lvl == 0)
/* 307 */       return "null "; 
/* 308 */     if (lvl == 0)
/* 309 */       return "" + tree.getValue() + " "; 
/* 310 */     return fullLevelOrder(tree.getLeft(), lvl - 1) + fullLevelOrder(tree.getLeft(), lvl - 1);
/*     */   }
/*     */   
/*     */   public ArrayList<RedBlackNode> postOrder(ArrayList<RedBlackNode> comp, RedBlackNode tree) {
/* 314 */     if (tree == null || tree.getValue() == null)
/* 315 */       return comp; 
/* 316 */     comp = postOrder(comp, tree.getLeft());
/* 317 */     comp = postOrder(comp, tree.getRight());
/* 318 */     comp.add(tree);
/* 319 */     return comp;
/*     */   }
/*     */   
/*     */   public ArrayList<RedBlackNode> preOrder(ArrayList<RedBlackNode> comp, RedBlackNode tree) {
/* 323 */     if (tree == null || tree.getValue() == null)
/* 324 */       return comp; 
/* 325 */     comp.add(tree);
/* 326 */     comp = preOrder(comp, tree.getLeft());
/* 327 */     comp = preOrder(comp, tree.getRight());
/* 328 */     return comp;
/*     */   }
/*     */   
/*     */   public Queue<Comparable> levelOrder() {
/* 332 */     Queue<RedBlackNode> q = new LinkedList<>();
/* 333 */     Queue<Comparable> rtn = new LinkedList<>();
/* 334 */     q.add(this.root);
/* 335 */     while (!q.isEmpty()) {
/*     */       
/* 337 */       RedBlackNode temp = q.poll();
/* 338 */       rtn.add(temp.getValue());
/* 339 */       if (temp.getLeft().getValue() != null)
/* 340 */         q.add(temp.getLeft()); 
/* 341 */       if (temp.getRight().getValue() != null)
/* 342 */         q.add(temp.getRight()); 
/*     */     } 
/* 344 */     return rtn;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 348 */     return (this.root == null || this.root.getValue() == null);
/*     */   }
/*     */   
/*     */   public RedBlackNode getRoot() {
/* 352 */     return this.root;
/*     */   }
/*     */   
/*     */   public RedBlackNode getNode(RedBlackNode iter, Comparable<Comparable> x) {
/* 356 */     if (iter == null || iter.getValue() == null)
/* 357 */       return null; 
/* 358 */     int dir = x.compareTo(iter.getValue());
/* 359 */     if (dir < 0)
/* 360 */       return getNode(iter.getLeft(), x); 
/* 361 */     if (dir > 0)
/* 362 */       return getNode(iter.getRight(), x); 
/* 363 */     return iter;
/*     */   }
/*     */ 
/*     */   
/*     */   public RedBlackNode getNode(RedBlackNode iter, int x) {
/* 368 */     if (iter == null || iter.getValue() == null)
/* 369 */       return null; 
/* 370 */     if (x < ((Integer)iter.getValue()).intValue())
/* 371 */       return getNode(iter.getLeft(), x); 
/* 372 */     if (x > ((Integer)iter.getValue()).intValue())
/* 373 */       return getNode(iter.getRight(), x); 
/* 374 */     return iter;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 379 */     String rtn = "";
/* 380 */     ArrayList<RedBlackNode> nodes = preOrder(new ArrayList<>(), this.root);
/* 381 */     for (RedBlackNode k : nodes)
/* 382 */       rtn = rtn + rtn + "\n"; 
/* 383 */     return rtn;
/*     */   }
/*     */   public String print() {
/* 386 */     StringBuilder add = new StringBuilder();
/* 387 */     if (this.root == null) {
/* 388 */       add.append("(XXXXXX)");
/* 389 */       return add.toString();
/*     */     } 
/* 391 */     int height = getNumLevels(this.root);
/* 392 */     int width = (int)Math.pow(2.0D, (height - 1));
/* 393 */     List<RedBlackNode> current = new ArrayList<>(1);
/* 394 */     List<RedBlackNode> next = new ArrayList<>(2);
/* 395 */     current.add(this.root);
/* 396 */     int maxHalfLength = 4;
/* 397 */     int elements = 1;
/* 398 */     StringBuilder sb = new StringBuilder(4 * width);
/* 399 */     for (int i = 0; i < 4 * width; i++)
/* 400 */       sb.append(' '); 
/* 401 */     for (int j = 0; j < height; j++) {
/* 402 */       sb.setLength(4 * ((int)Math.pow(2.0D, (height - 1 - j)) - 1));
/* 403 */       String textBuffer = sb.toString();
/* 404 */       for (RedBlackNode n : current) {
/* 405 */         add.append(textBuffer);
/* 406 */         if (n == null || n.getValue() == null) {
/* 407 */           add.append("        ");
/* 408 */           next.add(null);
/* 409 */           next.add(null);
/*     */         } else {
/* 411 */           add.append(String.format("(%6d)", new Object[] { n.getValue() }));
/* 412 */           next.add(n.getLeft());
/* 413 */           next.add(n.getRight());
/*     */         } 
/* 415 */         add.append(textBuffer);
/*     */       } 
/* 417 */       add.append("\n");
/* 418 */       if (j < height - 1) {
/* 419 */         for (RedBlackNode n : current) {
/* 420 */           add.append(textBuffer);
/* 421 */           if (n == null || n.getValue() == null) {
/* 422 */             add.append("        ");
/*     */           } else {
/* 424 */             add.append(String.format("%s      %s", new Object[] { (n.getLeft() == null || n.getLeft().getValue() == null) ? " " : "/", (n.getRight() == null || n.getRight().getValue() == null) ? " " : "\\" }));
/*     */           } 
/* 426 */           add.append(textBuffer);
/*     */         } 
/* 428 */         add.append("\n");
/*     */       } 
/* 430 */       elements *= 2;
/* 431 */       current = next;
/* 432 */       next = new ArrayList<>(elements);
/*     */     } 
/* 434 */     return add.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\gordo\Downloads\TreeVisualizer.jar!\RedBlackTree.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */