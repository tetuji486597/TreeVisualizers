/*    */ public class AVLNode {
/*    */   private AVLNode left;
/*  3 */   private int height = 1; private AVLNode right; private AVLNode parent;
/*    */   private int value;
/*    */   
/*    */   public AVLNode(int val) {
/*  7 */     this.value = val;
/*    */   }
/*    */   
/*    */   public AVLNode left() {
/* 11 */     return this.left;
/*    */   }
/*    */   
/*    */   public void setHeight(int height) {
/* 15 */     this.height = height;
/*    */   }
/*    */   
/*    */   public void setValue(int value) {
/* 19 */     this.value = value;
/*    */   }
/*    */   
/*    */   public void setLeft(AVLNode left) {
/* 23 */     this.left = left;
/*    */   }
/*    */   
/*    */   public void setRight(AVLNode right) {
/* 27 */     this.right = right;
/*    */   }
/*    */   
/*    */   public AVLNode right() {
/* 31 */     return this.right;
/*    */   }
/*    */   
/*    */   public AVLNode getParent() {
/* 35 */     return this.parent;
/*    */   }
/*    */   
/*    */   public int getHeight() {
/* 39 */     return this.height;
/*    */   }
/*    */   
/*    */   public int getValue() {
/* 43 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Users\gordo\Downloads\TreeVisualizer.jar!\AVLNode.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */