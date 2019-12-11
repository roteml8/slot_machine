import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class SlotMachineFrame extends JFrame  {

	
	
	
		public SlotMachineFrame(int w, int h){
			
			
			this.setSize(w, h);
			this.setTitle("Slot Machine Game");
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLayout(new BorderLayout());

			JButton playButton = new JButton("Play");
			final JLabel label = new JLabel("Click Play");
			label.setOpaque(true);
			label.setHorizontalAlignment(JLabel.CENTER);
			final SlotMachinePanel p = new SlotMachinePanel();
			this.add(label,BorderLayout.SOUTH);
			this.add(p, BorderLayout.CENTER);
			this.add(playButton,BorderLayout.WEST);
			this.setVisible(true);
			p.paintComponent(getGraphics());
			playButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					p.play();
					if (p.getIsWin())
						label.setText("YOU WON!");
					else
						label.setText("YOU LOST!");
				}
			});


			

		}
	
		
	
	
	
}
