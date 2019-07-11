package com.kitri.test.chart;
/*
import static org.junit.Assert.fail;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.junit.Test;

public class ChartTest extends JFrame {

	private JPanel contentPane;
	BarChartTest barChartTest;
//	ChartFactory
	JFreeChart chart;
	public JLabel lblChartImg;
	private BufferedImage bufferedImage;

	*//**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChartTest frame = new ChartTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	*//**
	 * Create the frame.
	 *//*
	public ChartTest() {
		barChartTest = new BarChartTest();
		barChartTest.setUp();

		uiInit();
		chart = createBarChart();
		
		bufferedImage = chart.createBufferedImage(lblChartImg.getWidth(), lblChartImg.getHeight());
		Image resizeImage = bufferedImage.getScaledInstance(lblChartImg.getWidth(), lblChartImg.getHeight(),
				BufferedImage.SCALE_FAST);
		ImageIcon icon = new ImageIcon(resizeImage);
		lblChartImg.setIcon(icon);
	}

	void uiInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Â÷Æ® ÀÌ¹ÌÁö
		lblChartImg = new JLabel("New label");
		lblChartImg.setBounds(12, 5, 417, 213);
		contentPane.add(lblChartImg);
	}

	*//**
	 * Create a bar chart with sample data in the range -3 to +3.
	 *
	 * @return The chart.
	 *//*
	private static JFreeChart createBarChart() {
		
		// create a dataset...
		Number[][] data = new Integer[][] { { new Integer(-3), new Integer(-2) }, { new Integer(-1), new Integer(1) },
				{ new Integer(2), new Integer(3) } };

		CategoryDataset dataset = DatasetUtilities.createCategoryDataset("S", "C", data);

		// create the chart...
		JFreeChart jFreeChart = ChartFactory.createBarChart("ÀÎ±â µµ¼­", "µµ¼­ÀÌ¸§", "´ë¿©È½¼ö", dataset, PlotOrientation.VERTICAL,
				true, // include
				// legend
				true, true);
		jFreeChart.getTitle().setFont(new Font("±¼¸²", Font.BOLD, 15));
		CategoryPlot plot = jFreeChart.getCategoryPlot();
		plot.getDomainAxis().setLabelFont(new Font("±¼¸²", Font.BOLD, 15));
		plot.getDomainAxis().setTickLabelFont(new Font("±¼¸²", Font.BOLD, 15));
		plot.getRangeAxis().setLabelFont(new Font("±¼¸²", Font.BOLD, 15));
		plot.getRangeAxis().setTickLabelFont(new Font("±¼¸²", Font.BOLD, 15));
		return jFreeChart;
	}// end createBarChart()

	
}*/
