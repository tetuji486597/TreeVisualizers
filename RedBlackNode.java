/*    */ public class RedBlackNode
/*    */ {
/*    */   private RedBlackNode left;
/*    */   private RedBlackNode right;
/*    */   private Comparable val;
/*    */   private ColorNode color;
/*    */   
/*    */   public RedBlackNode(Comparable v) {
/*  9 */     this.val = v;
/* 10 */     this.color = ColorNode.RED;
/* 11 */     this.left = new RedBlackNode();
/* 12 */     this.right = new RedBlackNode();
/*    */   }
/* 14 */   public RedBlackNode() { this.color = ColorNode.BLACK; this.val = null; }
/* 15 */   public void setLeft(RedBlackNode l) { this.left = l; }
/* 16 */   public void setRight(RedBlackNode r) { this.right = r; }
/* 17 */   public void setValue(Comparable v) { this.val = v; } public void setColor(ColorNode c) {
/* 18 */     this.color = c;
/*    */   }
/* 20 */   public RedBlackNode getLeft() { return this.left; }
/* 21 */   public RedBlackNode getRight() { return this.right; }
/* 22 */   public Comparable getValue() { return this.val; } public ColorNode getColor() {
/* 23 */     return this.color;
/*    */   }
/*    */   public String getStringColor() {
/* 26 */     if (this.color == ColorNode.RED) {
/* 27 */       return "Red";
/*    */     }
/* 29 */     return "Black";
/*    */   } public String toString() {
/* 31 */     return "Value:" + this.val + ", Left:" + ((this.left == null) ? "null" : (String)this.left.getValue()) + ", Right:" + ((this.right == null) ? "null" : (String)this.right.getValue()) + ", Color:" + getStringColor();
/*    */   }
/*    */ }


/* Location:              C:\Users\gordo\Downloads\TreeVisualizer.jar!\RedBlackNode.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */