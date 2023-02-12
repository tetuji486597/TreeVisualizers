/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ public class AVLTree
/*     */ {
/*     */   public class Node
/*     */   {
/*     */     private Node left;
/*     */     private Node right;
/*     */     private Node parent;
/*  12 */     private int height = 1;
/*     */     
/*     */     private int value;
/*     */     
/*     */     private Node(int val) {
/*  17 */       this.value = val;
/*     */     }
/*     */   }
/*     */   
/*     */   private int height(Node N) {
/*  22 */     if (N == null)
/*  23 */       return 0; 
/*  24 */     return N.height;
/*     */   }
/*     */   
/*     */   Node insert(Node node, int value) {
/*  28 */     if (node == null)
/*  29 */       return new Node(value); 
/*  30 */     if (value < node.value) {
/*  31 */       node.left = insert(node.left, value);
/*     */     } else {
/*  33 */       node.right = insert(node.right, value);
/*     */     } 
/*  35 */     node.height = Math.max(height(node.left), height(node.right)) + 1;
/*  36 */     int balance = getBalance(node);
/*  37 */     if (balance > 1 && value < node.left.value)
/*  38 */       return rightRotate(node); 
/*  39 */     if (balance < -1 && value > node.right.value)
/*  40 */       return leftRotate(node); 
/*  41 */     if (balance > 1 && value > node.left.value) {
/*  42 */       node.left = leftRotate(node.left);
/*  43 */       return rightRotate(node);
/*     */     } 
/*  45 */     if (balance < -1 && value < node.right.value) {
/*  46 */       node.right = rightRotate(node.right);
/*  47 */       return leftRotate(node);
/*     */     } 
/*  49 */     return node;
/*     */   }
/*     */   
/*     */   private Node rightRotate(Node y) {
/*  53 */     Node x = y.left;
/*  54 */     Node T2 = x.right;
/*  55 */     x.right = y;
/*  56 */     y.left = T2;
/*  57 */     y.height = Math.max(height(y.left), height(y.right)) + 1;
/*  58 */     x.height = Math.max(height(x.left), height(x.right)) + 1;
/*  59 */     return x;
/*     */   }
/*     */   
/*     */   private Node leftRotate(Node x) {
/*  63 */     Node y = x.right;
/*  64 */     Node T2 = y.left;
/*  65 */     y.left = x;
/*  66 */     x.right = T2;
/*  67 */     x.height = Math.max(height(x.left), height(x.right)) + 1;
/*  68 */     y.height = Math.max(height(y.left), height(y.right)) + 1;
/*  69 */     return y;
/*     */   }
/*     */   
/*     */   private int getBalance(Node N) {
/*  73 */     if (N == null)
/*  74 */       return 0; 
/*  75 */     return height(N.left) - height(N.right);
/*     */   }
/*     */   
/*     */   public void preOrder(Node root) {
/*  79 */     if (root != null) {
/*  80 */       preOrder(root.left);
/*  81 */       System.out.printf("%d ", new Object[] { Integer.valueOf(root.value) });
/*  82 */       preOrder(root.right);
/*     */     } 
/*     */   }
/*     */   
/*     */   private Node minValueNode(Node node) {
/*  87 */     Node current = node;
/*  88 */     while (current.left != null)
/*  89 */       current = current.left; 
/*  90 */     return current;
/*     */   }
/*     */   
/*     */   Node deleteNode(Node root, int value) {
/*  94 */     if (root == null)
/*  95 */       return root; 
/*  96 */     if (value < root.value) {
/*  97 */       root.left = deleteNode(root.left, value);
/*  98 */     } else if (value > root.value) {
/*  99 */       root.right = deleteNode(root.right, value);
/* 100 */     } else if (root.left == null || root.right == null) {
/* 101 */       Node temp = null;
/* 102 */       if (root.left != null) {
/* 103 */         temp = root.left;
/*     */       } else {
/* 105 */         temp = root.right;
/*     */       } 
/* 107 */       if (temp == null) {
/* 108 */         temp = root;
/* 109 */         root = null;
/*     */       } else {
/* 111 */         root = temp;
/*     */       } 
/*     */     } else {
/* 114 */       Node temp = minValueNode(root.right);
/* 115 */       root.value = temp.value;
/* 116 */       root.right = deleteNode(root.right, temp.value);
/*     */     } 
/* 118 */     if (root == null)
/* 119 */       return root; 
/* 120 */     root.height = Math.max(height(root.left), height(root.right)) + 1;
/* 121 */     int balance = getBalance(root);
/* 122 */     if (balance > 1 && getBalance(root.left) >= 0)
/* 123 */       return rightRotate(root); 
/* 124 */     if (balance > 1 && getBalance(root.left) < 0) {
/* 125 */       root.left = leftRotate(root.left);
/* 126 */       return rightRotate(root);
/*     */     } 
/* 128 */     if (balance < -1 && getBalance(root.right) <= 0)
/* 129 */       return leftRotate(root); 
/* 130 */     if (balance < -1 && getBalance(root.right) > 0) {
/* 131 */       root.right = rightRotate(root.right);
/* 132 */       return leftRotate(root);
/*     */     } 
/* 134 */     return root;
/*     */   }
/*     */   
/*     */   public String print(Node root) {
/* 138 */     StringBuilder add = new StringBuilder();
/* 139 */     if (root == null) {
/* 140 */       add.append("(XXXXXX)");
/* 141 */       return add.toString();
/*     */     } 
/* 143 */     int height = root.height;
/* 144 */     int width = (int)Math.pow(2.0D, (height - 1));
/* 145 */     List<Node> current = new ArrayList<>(1);
/* 146 */     List<Node> next = new ArrayList<>(2);
/* 147 */     current.add(root);
/* 148 */     int maxHalfLength = 4;
/* 149 */     int elements = 1;
/* 150 */     StringBuilder sb = new StringBuilder(4 * width);
/* 151 */     for (int i = 0; i < 4 * width; i++)
/* 152 */       sb.append(' '); 
/* 153 */     for (int j = 0; j < height; j++) {
/* 154 */       sb.setLength(4 * ((int)Math.pow(2.0D, (height - 1 - j)) - 1));
/* 155 */       String textBuffer = sb.toString();
/* 156 */       for (Node n : current) {
/* 157 */         add.append(textBuffer);
/* 158 */         if (n == null) {
/* 159 */           add.append("        ");
/* 160 */           next.add(null);
/* 161 */           next.add(null);
/*     */         } else {
/* 163 */           add.append(String.format("(%6d)", new Object[] { Integer.valueOf(n.value) }));
/* 164 */           next.add(n.left);
/* 165 */           next.add(n.right);
/*     */         } 
/* 167 */         add.append(textBuffer);
/*     */       } 
/* 169 */       add.append("\n");
/* 170 */       if (j < height - 1) {
/* 171 */         for (Node n : current) {
/* 172 */           add.append(textBuffer);
/* 173 */           if (n == null) {
/* 174 */             add.append("        ");
/*     */           } else {
/* 176 */             add.append(String.format("%s      %s", new Object[] { (n.left == null) ? " " : "/", (n.right == null) ? " " : "\\" }));
/*     */           } 
/* 178 */           add.append(textBuffer);
/*     */         } 
/* 180 */         add.append("\n");
/*     */       } 
/* 182 */       elements *= 2;
/* 183 */       current = next;
/* 184 */       next = new ArrayList<>(elements);
/*     */     } 
/* 186 */     return add.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\gordo\Downloads\TreeVisualizer.jar!\AVLTree.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */