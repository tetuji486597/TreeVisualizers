/*    */ public class BinaryNode
/*    */ {
/*    */   private BinaryNode left;
/*    */   
/*    */   public BinaryNode() {
/*  6 */     this.myValue = null;
/*  7 */     this.left = null;
/*  8 */     this.right = null;
/*    */   }
/*    */   private BinaryNode right; private Comparable myValue;
/*    */   public BinaryNode(Comparable x) {
/* 12 */     this.myValue = x;
/* 13 */     this.left = null;
/* 14 */     this.right = null;
/*    */   }
/*    */   
/*    */   public BinaryNode(Comparable value, BinaryNode leftSubtree, BinaryNode rightSubtree) {
/* 18 */     this.myValue = value;
/* 19 */     this.left = leftSubtree;
/* 20 */     this.right = rightSubtree;
/*    */   }
/*    */   
/*    */   public void setValue(Comparable value) {
/* 24 */     this.myValue = value;
/*    */   }
/*    */   public void setLeft(BinaryNode newLeft) {
/* 27 */     this.left = newLeft;
/*    */   }
/*    */   public void setRight(BinaryNode newRight) {
/* 30 */     this.right = newRight;
/*    */   }
/*    */   
/*    */   public Comparable getValue() {
/* 34 */     return this.myValue;
/*    */   }
/*    */   public BinaryNode left() {
/* 37 */     return this.left;
/*    */   }
/*    */   public BinaryNode right() {
/* 40 */     return this.right;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 47 */     String temp = "Value:" + this.myValue + ", Left:" + ((this.left == null) ? null : (String)this.left.myValue) + ", Right:" + ((this.right == null) ? null : (String)this.right.myValue);
/* 48 */     return temp;
/*    */   }
/*    */ }


/* Location:              C:\Users\gordo\Downloads\TreeVisualizer.jar!\BinaryNode.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */