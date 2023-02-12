/*     */ import com.intellij.uiDesigner.core.GridConstraints;
/*     */ import com.intellij.uiDesigner.core.Spacer;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Insets;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.ButtonGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRadioButton;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class Graphic extends JFrame {
/*     */   private JTextField textField1;
/*     */   private JButton insertButton;
/*     */   private JButton delete;
/*     */   private JPanel mainPanel;
/*     */   private JTextPane textPane1;
/*     */   private AVLTree.Node root;
/*  27 */   private int modeChosen = 0; private JButton deleteButton; private JTextArea textArea1; private JLabel enter; private JRadioButton BSTRadioButton; private JRadioButton RBRadioButton; private JRadioButton AVLRadioButton; private JLabel treeLabel; private AVLTree avltree;
/*     */   private BinarySearchTree bstree;
/*     */   private RedBlackTree rbtree;
/*     */   
/*     */   public Graphic() {
/*  32 */     super("Tree Visualizer");
/*  33 */     this.root = null;
/*  34 */     $$$setupUI$$$(); this.treeLabel.setText("Binary Search Tree Visualizer");
/*  35 */     this.bstree = new BinarySearchTree();
/*  36 */     setContentPane(this.mainPanel);
/*  37 */     setSize(1750, 800);
/*  38 */     setDefaultCloseOperation(3);
/*  39 */     this.textArea1.setWrapStyleWord(true);
/*  40 */     setVisible(true);
/*  41 */     ButtonGroup mode = new ButtonGroup();
/*  42 */     mode.add(this.BSTRadioButton);
/*  43 */     mode.add(this.RBRadioButton);
/*  44 */     mode.add(this.AVLRadioButton);
/*  45 */     this.BSTRadioButton.setSelected(true);
/*  46 */     getRootPane().setDefaultButton(this.insertButton);
/*  47 */     this.BSTRadioButton.setMnemonic(49);
/*  48 */     this.RBRadioButton.setMnemonic(50);
/*  49 */     this.AVLRadioButton.setMnemonic(51);
/*  50 */     this.enter.setFont(new Font("Arial Bold", 0, 20));
/*  51 */     this.treeLabel.setFont(new Font("Arial Bold", 0, 20));
/*  52 */     this.insertButton.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  54 */             if (Graphic.this.textField1.getText().equals("") || Graphic.this.textField1.getText().isBlank())
/*     */               return; 
/*  56 */             if (Graphic.this.AVLRadioButton.isSelected()) {
/*  57 */               Graphic.this.root = Graphic.this.avltree.insert(Graphic.this.root, Integer.parseInt(Graphic.this.textField1.getText()));
/*  58 */               Graphic.this.textField1.setText("");
/*  59 */               Graphic.this.textArea1.setFont(new Font("Monospaced", 0, 15));
/*  60 */               System.out.println(Graphic.this.avltree.print(Graphic.this.root));
/*  61 */               Graphic.this.textArea1.setText(Graphic.this.avltree.print(Graphic.this.root));
/*  62 */             } else if (Graphic.this.BSTRadioButton.isSelected()) {
/*  63 */               Graphic.this.bstree.add(new BinaryNode(Integer.valueOf(Integer.parseInt(Graphic.this.textField1.getText()))));
/*  64 */               Graphic.this.textField1.setText("");
/*  65 */               Graphic.this.textArea1.setFont(new Font("Monospaced", 0, 15));
/*  66 */               Graphic.this.textArea1.setText(Graphic.this.bstree.print());
/*  67 */             } else if (Graphic.this.RBRadioButton.isSelected()) {
/*  68 */               Graphic.this.rbtree.add(new RedBlackNode(Integer.valueOf(Integer.parseInt(Graphic.this.textField1.getText()))));
/*  69 */               Graphic.this.textField1.setText("");
/*  70 */               Graphic.this.textArea1.setFont(new Font("Monospaced", 0, 15));
/*  71 */               Graphic.this.textArea1.setText(Graphic.this.rbtree.print());
/*     */             } 
/*     */           }
/*     */         });
/*  75 */     this.deleteButton.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  77 */             if (Graphic.this.textField1.getText().equals("") || Graphic.this.textField1.getText().isBlank())
/*     */               return; 
/*  79 */             if (Graphic.this.AVLRadioButton.isSelected()) {
/*  80 */               Graphic.this.root = Graphic.this.avltree.deleteNode(Graphic.this.root, Integer.parseInt(Graphic.this.textField1.getText()));
/*  81 */               Graphic.this.textField1.setText("");
/*  82 */               Graphic.this.textArea1.setText(Graphic.this.avltree.print(Graphic.this.root));
/*  83 */             } else if (Graphic.this.BSTRadioButton.isSelected()) {
/*  84 */               Graphic.this.bstree.remove(Integer.valueOf(Integer.parseInt(Graphic.this.textField1.getText())));
/*  85 */               Graphic.this.textField1.setText("");
/*  86 */               Graphic.this.textArea1.setText(Graphic.this.bstree.print());
/*  87 */             } else if (Graphic.this.RBRadioButton.isSelected()) {
/*  88 */               Graphic.this.rbtree.remove(Integer.valueOf(Integer.parseInt(Graphic.this.textField1.getText())));
/*  89 */               Graphic.this.textField1.setText("");
/*  90 */               Graphic.this.textArea1.setText(Graphic.this.rbtree.print());
/*     */             } 
/*     */           }
/*     */         });
/*  94 */     this.BSTRadioButton.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/*  97 */             Graphic.this.bstree = new BinarySearchTree();
/*  98 */             Graphic.this.root = null;
/*  99 */             Graphic.this.textArea1.setText("");
/* 100 */             Graphic.this.textField1.setText("");
/* 101 */             Graphic.this.treeLabel.setText("Binary Search Tree Visualizer");
/*     */           }
/*     */         });
/* 104 */     this.RBRadioButton.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/* 107 */             Graphic.this.rbtree = new RedBlackTree();
/* 108 */             Graphic.this.root = null;
/* 109 */             Graphic.this.textArea1.setText("");
/* 110 */             Graphic.this.textField1.setText("");
/* 111 */             Graphic.this.treeLabel.setText("Red Black Tree Visualizer");
/*     */           }
/*     */         });
/* 114 */     this.AVLRadioButton.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/* 117 */             Graphic.this.avltree = new AVLTree();
/* 118 */             Graphic.this.root = null;
/* 119 */             Graphic.this.textArea1.setText("");
/* 120 */             Graphic.this.textField1.setText("");
/* 121 */             Graphic.this.treeLabel.setText("AVL Tree Visualizer");
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 127 */     FlatNordIJTheme.setup();
/* 128 */     Graphic graphic = new Graphic();
/*     */   }
/*     */ }


/* Location:              C:\Users\gordo\Downloads\TreeVisualizer.jar!\Graphic.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */