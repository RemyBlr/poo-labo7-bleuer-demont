package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * The JCalculator class represents a simple calculator Graphical User
 * Interface (GUI).
 * It extends JFrame and provides a graphical user interface with buttons for
 * numeric input, arithmetic operations, and memory operations.
 * The calculator supports basic arithmetic operations, memory storage, and retrieval.
 * The user can interact with the calculator by clicking on buttons.
 * The current value, stack, and memory are displayed on the GUI.
 * The calculator uses the State class to manage its state.
 * This class has been largely supplied, with only a few additions.
 *
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see State
 * @see Operator
 */
public class JCalculator extends JFrame
{
  // Tableau representant une pile vide
  private static final String[] empty = { "< empty stack >" };

  // État de la calculatrice
  private State state = new State();

  // Zone de texte contenant la valeur introduite ou resultat courant
  private final JTextField jNumber = new JTextField("0");

  // Composant liste representant le contenu de la pile
  private final JList<String> jStack = new JList<>(empty);

  // Contraintes pour le placement des composants graphiques
  private final GridBagConstraints constraints = new GridBagConstraints();


  // Mise a jour de l'interface apres une operation (jList et jStack)
  private void update()
  {
    // Modifier une zone de texte, JTextField.setText(string nom)
    // Modifier un composant liste, JList.setListData(Object[] tableau)
    if (state.isError()) {
      jNumber.setText("Error");
      // Désactiver les boutons ou effectuer d'autres actions nécessaires lorsqu'une erreur se produit
    } else {
      jNumber.setText(state.getCurrentValue());
    }

    if (state.getStack().isEmpty())
      jStack.setListData(empty);
    else
      jStack.setListData(state.getStack().toArrayOfString());
  }

  // Ajout d'un bouton dans l'interface et de l'operation associee,
  // instance de la classe Operation, possedeant une methode execute()
  private void addOperatorButton(String name, int x, int y, Color color, 
				 final Operator operator)
  {
    JButton b = new JButton(name);
    b.setForeground(color);
    constraints.gridx = x;
    constraints.gridy = y;
    getContentPane().add(b, constraints);
    b.addActionListener((e) -> {
	operator.execute(state);
	update();
    });
  }

  public JCalculator() 
  {
    super("JCalculator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(new GridBagLayout());

    // Contraintes des composants graphiques
    constraints.insets = new Insets(3, 3, 3, 3);
    constraints.fill = GridBagConstraints.HORIZONTAL;

    // Nombre courant
    jNumber.setEditable(false);
    jNumber.setBackground(Color.WHITE);
    jNumber.setHorizontalAlignment(JTextField.RIGHT);
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.gridwidth = 5;
    getContentPane().add(jNumber, constraints);
    constraints.gridwidth = 1; // reset width

    // Rappel de la valeur en memoire
    addOperatorButton("MR", 0, 1, Color.RED, Operator.memoryRecall);

    // Stockage d'une valeur en memoire
    addOperatorButton("MS", 1, 1, Color.RED, Operator.memoryStore);

    // Backspace
    addOperatorButton("<=", 2, 1, Color.RED, Operator.backspace);

    // Mise a zero de la valeur courante + suppression des erreurs
    addOperatorButton("CE", 3, 1, Color.RED, Operator.clearEntry);

    // Comme CE + vide la pile
    addOperatorButton("C",  4, 1, Color.RED, Operator.clear);

    // Boutons 1-9
    for (int i = 1; i < 10; i++) 
      addOperatorButton(String.valueOf(i), (i - 1) % 3, 4 - (i - 1) / 3, 
			Color.BLUE, Operator.numbers[i]);

    // Bouton 0
    addOperatorButton("0", 0, 5, Color.BLUE, Operator.numbers[0]);

    // Changement de signe de la valeur courante
    addOperatorButton("+/-", 1, 5, Color.BLUE, Operator.opposite);

    // Operateur point (chiffres apres la virgule ensuite)
    addOperatorButton(".", 2, 5, Color.BLUE, Operator.point);

    // Operateurs arithmetiques a deux operandes: /, *, -, +
    addOperatorButton("/", 3, 2, Color.RED, Operator.division);
    addOperatorButton("*", 3, 3, Color.RED, Operator.multiplication);
    addOperatorButton("-", 3, 4, Color.RED, Operator.subtraction);
    addOperatorButton("+", 3, 5, Color.RED, Operator.addition);

    // Operateurs arithmetiques a un operande: 1/x, x^2, Sqrt
    addOperatorButton("1/x", 4, 2, Color.RED, Operator.reciprocal);
    addOperatorButton("x^2", 4, 3, Color.RED, Operator.square);
    addOperatorButton("Sqrt", 4, 4, Color.RED, Operator.squareRoot);

    // Entree: met la valeur courante sur le sommet de la pile
    addOperatorButton("Ent", 4, 5, Color.RED, Operator.enter);

    // Affichage de la pile
    JLabel jLabel = new JLabel("Stack");
    jLabel.setFont(new Font("Dialog", 0, 12));
    jLabel.setHorizontalAlignment(JLabel.CENTER);
    constraints.gridx = 5;
    constraints.gridy = 0;
    getContentPane().add(jLabel, constraints);

    jStack.setFont(new Font("Dialog", 0, 12));
    jStack.setVisibleRowCount(8);
    JScrollPane scrollPane = new JScrollPane(jStack);
    constraints.gridx = 5;
    constraints.gridy = 1;
    constraints.gridheight = 5;
    getContentPane().add(scrollPane, constraints);
    constraints.gridheight = 1; // reset height

    setResizable(false);
    pack();
    setVisible(true);
  }
}
