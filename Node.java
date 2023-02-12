/*    */ public class Node {
/*    */   private Node left;
/*  3 */   private int height = 1; private Node right; private Node parent;
/*    */   private int value;
/*    */   
/*    */   private Node(int val) {
/*  7 */     this.value = val;
/*    */   }
/*    */   
/*    */   private int getHeight(Node N) {
/* 11 */     if (N == null)
/* 12 */       return -1; 
/* 13 */     return 1 + Math.max(getHeight(N.left), getHeight(N.right));
/*    */   }
/*    */ }


/* Location:              C:\Users\gordo\Downloads\TreeVisualizer.jar!\Node.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */