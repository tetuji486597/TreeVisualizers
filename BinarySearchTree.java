/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Queue;
/*     */ 
/*     */ public class BinarySearchTree {
/*   7 */   private BinaryNode root = null;
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(BinaryNode x) {
/*  12 */     if (this.root == null) {
/*     */       
/*  14 */       this.root = x;
/*     */       return;
/*     */     } 
/*  17 */     add(this.root, x);
/*     */   }
/*     */ 
/*     */   
/*     */   private void add(BinaryNode parent, BinaryNode x) {
/*  22 */     if (parent == null)
/*  23 */       return;  if (x.getValue().compareTo(parent.getValue()) < 0) {
/*  24 */       if (parent.left() == null) {
/*  25 */         parent.setLeft(x);
/*     */       } else {
/*  27 */         add(parent.left(), x);
/*     */       } 
/*  29 */     } else if (parent.right() == null) {
/*  30 */       parent.setRight(x);
/*     */     } else {
/*  32 */       add(parent.right(), x);
/*     */     } 
/*     */   }
/*     */   public String preOrder() {
/*  36 */     return preOrder(this.root).trim();
/*     */   }
/*     */   
/*     */   private String preOrder(BinaryNode k) {
/*  40 */     String temp = "";
/*  41 */     if (k != null) {
/*  42 */       temp = temp + temp + " ";
/*  43 */       temp = temp + temp;
/*  44 */       temp = temp + temp;
/*     */     } 
/*  46 */     return temp;
/*     */   }
/*     */   
/*     */   public String postOrder() {
/*  50 */     return postOrder(this.root).trim();
/*     */   }
/*     */   
/*     */   private String postOrder(BinaryNode k) {
/*  54 */     String temp = "";
/*  55 */     if (k != null) {
/*  56 */       temp = temp + temp;
/*  57 */       temp = temp + temp;
/*  58 */       temp = temp + temp + " ";
/*     */     } 
/*  60 */     return temp;
/*     */   }
/*     */   
/*     */   public String inOrder() {
/*  64 */     return inOrder(this.root).trim();
/*     */   }
/*     */   
/*     */   private String inOrder(BinaryNode k) {
/*  68 */     String temp = "";
/*  69 */     if (k != null) {
/*  70 */       temp = temp + temp;
/*  71 */       temp = temp + temp + " ";
/*  72 */       temp = temp + temp;
/*     */     } 
/*  74 */     return temp;
/*     */   }
/*     */   
/*     */   public String reverseOrder() {
/*  78 */     return reverseOrder(this.root).trim();
/*     */   }
/*     */   
/*     */   private String reverseOrder(BinaryNode k) {
/*  82 */     String temp = "";
/*  83 */     if (k != null) {
/*  84 */       temp = temp + temp;
/*  85 */       temp = temp + temp + " ";
/*  86 */       temp = temp + temp;
/*     */     } 
/*  88 */     return temp;
/*     */   }
/*     */   
/*     */   public int getHeight() {
/*  92 */     return getHeight(this.root);
/*     */   }
/*     */   
/*     */   private int getHeight(BinaryNode k) {
/*  96 */     if (k == null) return -1; 
/*  97 */     return 1 + Math.max(getHeight(k.left()), 
/*  98 */         getHeight(k.right()));
/*     */   }
/*     */   
/*     */   public int getLeafCount() {
/* 102 */     return getLeafCount(this.root);
/*     */   }
/*     */   
/*     */   private int getLeafCount(BinaryNode k) {
/* 106 */     if (k == null) return 0; 
/* 107 */     if (k.left() == null && k.right() == null) return 1; 
/* 108 */     return getLeafCount(k.left()) + getLeafCount(k.right());
/*     */   }
/*     */   
/*     */   public int getWidth() {
/* 112 */     if (this.root == null) return 0; 
/* 113 */     int count = 1, width = 1;
/* 114 */     String[] arr = new String[getNodeCount()];
/* 115 */     arr = levelOrder().<String>toArray(arr);
/* 116 */     for (int i = 1; i < getNodeCount(); i++) {
/* 117 */       if (arr[i].compareTo(arr[i - 1]) < 0) {
/* 118 */         System.out.println(arr[i - 1] + " " + arr[i - 1] + " " + arr[i]);
/* 119 */         if (count > width) width = count; 
/* 120 */         count = 0;
/*     */       } 
/* 122 */       count++;
/*     */     } 
/* 124 */     System.out.println(levelOrder());
/* 125 */     return width;
/*     */   }
/*     */   
/*     */   public int getNodeCount() {
/* 129 */     return getNodeCount(this.root);
/*     */   }
/*     */   
/*     */   private int getNodeCount(BinaryNode root) {
/* 133 */     if (root == null) return 0; 
/* 134 */     return 1 + getNodeCount(root.left()) + getNodeCount(root.right());
/*     */   }
/*     */   
/*     */   public boolean isFull() {
/* 138 */     return isFull(this.root);
/*     */   }
/*     */   
/*     */   private boolean isFull(BinaryNode root) {
/* 142 */     if (root == null) return false; 
/* 143 */     if (root.left() != null && root.right() != null) {
/* 144 */       if (!isFull(root.left())) return false; 
/* 145 */       if (!isFull(root.right())) return false; 
/* 146 */       return true;
/* 147 */     }  if (root.left() == null && root.right() == null) return true; 
/* 148 */     return false;
/*     */   }
/*     */   
/*     */   public boolean contains(Comparable word) {
/* 152 */     return contains(this.root, word);
/*     */   }
/*     */   
/*     */   private boolean contains(BinaryNode root, Comparable compare) {
/* 156 */     if (root == null) return false; 
/* 157 */     if (root.getValue().compareTo(compare) == 0) return true; 
/* 158 */     if (root.getValue().compareTo(compare) >= 0) return contains(root.left(), compare); 
/* 159 */     return contains(root.right(), compare);
/*     */   }
/*     */   
/*     */   public ArrayList<Comparable> levelOrder() {
/* 163 */     ArrayList<Comparable> temp = new ArrayList<>();
/* 164 */     Queue<BinaryNode> queue = new LinkedList<>();
/* 165 */     queue.offer(this.root);
/* 166 */     while (!queue.isEmpty()) {
/* 167 */       BinaryNode k = queue.poll();
/* 168 */       temp.add(k.getValue());
/* 169 */       if (k.left() != null)
/* 170 */         queue.offer(k.left()); 
/* 171 */       if (k.right() != null)
/* 172 */         queue.offer(k.right()); 
/*     */     } 
/* 174 */     return temp;
/*     */   }
/*     */   
/*     */   public ArrayList<Comparable> levelOrderWithNulls() {
/* 178 */     ArrayList<Comparable> temp = new ArrayList<>();
/* 179 */     Queue<BinaryNode> queue = new LinkedList<>();
/* 180 */     queue.offer(this.root);
/* 181 */     int amount = 0;
/* 182 */     for (int i = 0; i <= getHeight(); i++) {
/* 183 */       amount += (int)Math.pow(2.0D, i);
/*     */     }
/* 185 */     while (temp.size() < amount) {
/* 186 */       BinaryNode k = queue.poll();
/* 187 */       if (k == null) {
/* 188 */         temp.add("-");
/* 189 */         queue.offer((BinaryNode)null);
/* 190 */         queue.offer((BinaryNode)null);
/*     */         continue;
/*     */       } 
/* 193 */       temp.add(k.getValue());
/* 194 */       queue.offer(k.left());
/* 195 */       queue.offer(k.right());
/*     */     } 
/*     */     
/* 198 */     return temp;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<Comparable> printLevelOrder() {
/* 203 */     ArrayList<Comparable> temp = new ArrayList<>();
/* 204 */     Queue<BinaryNode> queue = new LinkedList<>();
/* 205 */     queue.offer(this.root);
/* 206 */     BinaryNode k = queue.poll();
/* 207 */     Comparable<Comparable> last = k.getValue();
/* 208 */     temp.add(k.getValue());
/* 209 */     if (k.left() != null)
/* 210 */       queue.offer(k.left()); 
/* 211 */     if (k.right() != null)
/* 212 */       queue.offer(k.right()); 
/* 213 */     System.out.print(last);
/* 214 */     while (!queue.isEmpty()) {
/* 215 */       k = queue.poll();
/* 216 */       last = null;
/* 217 */       temp.add(k.getValue());
/* 218 */       last = temp.get(temp.size() - 2);
/* 219 */       if (last.compareTo(k.getValue()) > 0) System.out.println(); 
/* 220 */       System.out.print("" + k.getValue() + " ");
/* 221 */       if (k.left() != null)
/* 222 */         queue.offer(k.left()); 
/* 223 */       if (k.right() != null)
/* 224 */         queue.offer(k.right()); 
/*     */     } 
/* 226 */     return temp;
/*     */   }
/*     */   
/*     */   public String graphicalTree() {
/* 230 */     ArrayList<Comparable> levelorder = levelOrderWithNulls();
/* 231 */     int amountPossibleLeaves = (int)Math.pow(2.0D, getHeight());
/* 232 */     String tree = "";
/* 233 */     int amtLines = (int)Math.pow(2.0D, (getHeight() - 1));
/* 234 */     int height = getHeight();
/*     */     int i;
/* 236 */     for (i = 1; i <= amountPossibleLeaves; i *= 2) {
/* 237 */       int amountSpaces = amountPossibleLeaves / i - 1;
/* 238 */       for (int x = 0; x < i; x++) {
/* 239 */         if (levelorder.isEmpty()) {
/* 240 */           tree = tree + tree + "-" + spaces(amountSpaces);
/*     */         } else {
/* 242 */           tree = tree + tree + spaces(amountSpaces) + levelorder.remove(0);
/*     */         } 
/* 244 */       }  System.out.println(amtLines);
/* 245 */       tree = tree + "\n\n";
/*     */     } 
/* 247 */     return tree;
/*     */   }
/*     */   
/*     */   public String spaces(int x) {
/* 251 */     StringBuilder c = new StringBuilder();
/* 252 */     for (int i = 0; i < x; i++) {
/* 253 */       c.append(" ");
/*     */     }
/* 255 */     return c.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 260 */     return inOrder();
/*     */   }
/*     */   
/*     */   public Comparable largest() {
/* 264 */     return largest(this.root);
/*     */   }
/*     */   
/*     */   private Comparable largest(BinaryNode root) {
/* 268 */     if (root == null) return null; 
/* 269 */     BinaryNode temp = root;
/* 270 */     while (temp.right() != null) {
/* 271 */       temp = temp.right();
/*     */     }
/* 273 */     return temp.getValue();
/*     */   }
/*     */   
/*     */   public Comparable smallest() {
/* 277 */     if (this.root == null) return null; 
/* 278 */     BinaryNode temp = this.root;
/* 279 */     while (temp.left() != null) {
/* 280 */       temp = temp.left();
/*     */     }
/* 282 */     return temp.getValue();
/*     */   }
/*     */   
/*     */   public BinaryNode remove(Comparable target) {
/* 286 */     if (this.root == null) return null; 
/* 287 */     BinaryNode temp = this.root;
/*     */     
/* 289 */     if (this.root.getValue().equals(target)) {
/* 290 */       if (this.root.left() == null && this.root.right() == null) {
/* 291 */         this.root = null;
/* 292 */         return temp;
/*     */       } 
/* 294 */       if (this.root.left() == null) {
/* 295 */         this.root = this.root.right();
/* 296 */         temp.setRight(null);
/*     */         
/* 298 */         return temp;
/*     */       } 
/* 300 */       if (this.root.right() == null) {
/* 301 */         this.root = this.root.left();
/* 302 */         temp.setLeft(null);
/* 303 */         return temp;
/*     */       } 
/*     */       
/* 306 */       BinaryNode inorderSuccessor = predecessor(this.root);
/* 307 */       inorderSuccessor.setRight(this.root.right());
/* 308 */       this.root = this.root.left();
/* 309 */       temp.setLeft(null);
/* 310 */       temp.setRight(null);
/* 311 */       return temp;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 321 */     return remove(this.root, target);
/*     */   }
/*     */ 
/*     */   
/*     */   private BinaryNode search(BinaryNode parent, Comparable<Comparable> target) {
/* 326 */     if (parent == null) return null; 
/* 327 */     if ((parent.left() != null && parent.left().getValue().equals(target)) || (parent
/* 328 */       .right() != null && parent.right().getValue().equals(target)))
/* 329 */       return parent; 
/* 330 */     if (target.compareTo(parent.getValue()) < 0) {
/* 331 */       return search(parent.left(), target);
/*     */     }
/* 333 */     return search(parent.right(), target);
/*     */   }
/*     */ 
/*     */   
/*     */   private BinaryNode search(BinaryNode parent, Integer target) {
/* 338 */     if (parent == null) return null; 
/* 339 */     if ((parent.left() != null && parent.left().getValue().equals(target)) || (parent
/* 340 */       .right() != null && parent.right().getValue().equals(target)))
/* 341 */       return parent; 
/* 342 */     if (target.intValue() < ((Integer)parent.getValue()).intValue()) {
/* 343 */       return search(parent.left(), target);
/*     */     }
/* 345 */     return search(parent.right(), target);
/*     */   }
/*     */   
/*     */   public String print() {
/* 349 */     StringBuilder add = new StringBuilder();
/* 350 */     if (this.root == null) {
/* 351 */       add.append("(XXXXXX)");
/* 352 */       return add.toString();
/*     */     } 
/* 354 */     int height = getHeight(this.root) + 1;
/* 355 */     int width = (int)Math.pow(2.0D, (height - 1));
/* 356 */     List<BinaryNode> current = new ArrayList<>(1);
/* 357 */     List<BinaryNode> next = new ArrayList<>(2);
/* 358 */     current.add(this.root);
/* 359 */     int maxHalfLength = 4;
/* 360 */     int elements = 1;
/* 361 */     StringBuilder sb = new StringBuilder(4 * width);
/* 362 */     for (int i = 0; i < 4 * width; i++)
/* 363 */       sb.append(' '); 
/* 364 */     for (int j = 0; j < height; j++) {
/* 365 */       sb.setLength(4 * ((int)Math.pow(2.0D, (height - 1 - j)) - 1));
/* 366 */       String textBuffer = sb.toString();
/* 367 */       for (BinaryNode n : current) {
/* 368 */         add.append(textBuffer);
/* 369 */         if (n == null) {
/* 370 */           add.append("        ");
/* 371 */           next.add(null);
/* 372 */           next.add(null);
/*     */         } else {
/* 374 */           add.append(String.format("(%6d)", new Object[] { n.getValue() }));
/* 375 */           next.add(n.left());
/* 376 */           next.add(n.right());
/*     */         } 
/* 378 */         add.append(textBuffer);
/*     */       } 
/* 380 */       add.append("\n");
/* 381 */       if (j < height - 1) {
/* 382 */         for (BinaryNode n : current) {
/* 383 */           add.append(textBuffer);
/* 384 */           if (n == null) {
/* 385 */             add.append("        ");
/*     */           } else {
/* 387 */             add.append(String.format("%s      %s", new Object[] { (n.left() == null) ? " " : "/", (n.right() == null) ? " " : "\\" }));
/*     */           } 
/* 389 */           add.append(textBuffer);
/*     */         } 
/* 391 */         add.append("\n");
/*     */       } 
/* 393 */       elements *= 2;
/* 394 */       current = next;
/* 395 */       next = new ArrayList<>(elements);
/*     */     } 
/* 397 */     return add.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private BinaryNode remove(BinaryNode startNode, Comparable target) {
/* 403 */     BinaryNode parent = search(startNode, target);
/* 404 */     if (parent == null) return null;
/*     */     
/* 406 */     boolean isLeft = (parent.left() != null && parent.left().getValue().equals(target));
/* 407 */     BinaryNode nodeToRemove = isLeft ? parent.left() : parent.right();
/* 408 */     if (nodeToRemove.left() == null && nodeToRemove.right() == null) {
/*     */ 
/*     */       
/* 411 */       if (isLeft) {
/* 412 */         parent.setLeft(null);
/*     */       } else {
/* 414 */         parent.setRight(null);
/* 415 */       }  return nodeToRemove;
/* 416 */     }  if (nodeToRemove.left() == null) {
/*     */ 
/*     */       
/* 419 */       if (isLeft) {
/* 420 */         parent.setLeft(nodeToRemove.right());
/*     */       } else {
/* 422 */         parent.setRight(nodeToRemove.right());
/* 423 */       }  nodeToRemove.setRight(null);
/* 424 */       return nodeToRemove;
/*     */     } 
/* 426 */     if (nodeToRemove.right() == null) {
/*     */ 
/*     */       
/* 429 */       if (isLeft) {
/* 430 */         parent.setLeft(nodeToRemove.left());
/*     */       } else {
/* 432 */         parent.setRight(nodeToRemove.left());
/* 433 */       }  nodeToRemove.setLeft(null);
/* 434 */       return nodeToRemove;
/*     */     } 
/*     */ 
/*     */     
/* 438 */     BinaryNode inorderSuccessor = successor(nodeToRemove);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 451 */     swap(inorderSuccessor, nodeToRemove);
/* 452 */     if (nodeToRemove.right() == inorderSuccessor) {
/*     */       
/* 454 */       nodeToRemove.setRight(inorderSuccessor.left());
/* 455 */       inorderSuccessor.setRight(null);
/* 456 */       return inorderSuccessor;
/*     */     } 
/* 458 */     return remove(nodeToRemove.right(), target);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private BinaryNode successor(BinaryNode k) {
/* 464 */     BinaryNode temp = k;
/* 465 */     temp = temp.right();
/* 466 */     while (temp.left() != null)
/* 467 */       temp = temp.left(); 
/* 468 */     return temp;
/*     */   }
/*     */   
/*     */   private BinaryNode predecessor(BinaryNode k) {
/* 472 */     BinaryNode temp = k;
/* 473 */     temp = temp.left();
/* 474 */     while (temp.right() != null)
/* 475 */       temp = temp.right(); 
/* 476 */     return temp;
/*     */   }
/*     */   
/*     */   public void printFullTree(int levels) {
/* 480 */     ArrayList<Comparable> temp = new ArrayList<>();
/* 481 */     Queue<BinaryNode> queue = new LinkedList<>();
/* 482 */     queue.offer(this.root);
/* 483 */     for (int i = 0; i < Math.pow(2.0D, levels); i++) {
/* 484 */       BinaryNode k = queue.poll();
/* 485 */       temp.add((k == null) ? null : k.getValue());
/* 486 */       queue.offer((k == null || k.left() == null) ? null : k.left());
/* 487 */       queue.offer((k == null || k.right() == null) ? null : k.right());
/*     */     } 
/* 489 */     Iterator<Comparable> iter = temp.iterator();
/* 490 */     for (int j = 0; j < levels; j++) {
/* 491 */       for (int k = 0; k < Math.pow(2.0D, j); k++) {
/* 492 */         System.out.print("" + iter.next() + "|");
/*     */       }
/* 494 */       System.out.println();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void swap(BinaryNode x, BinaryNode y) {
/* 499 */     Comparable k = x.getValue();
/* 500 */     x.setValue(y.getValue());
/* 501 */     y.setValue(k);
/*     */   }
/*     */ }


/* Location:              C:\Users\gordo\Downloads\TreeVisualizer.jar!\BinarySearchTree.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */