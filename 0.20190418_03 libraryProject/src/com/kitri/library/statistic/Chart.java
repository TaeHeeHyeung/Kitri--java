package com.kitri.library.statistic;

/*import static org.junit.Assert.fail;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.junit.Test;

import com.kitri.library.db.BookDao;
import com.kitri.library.db.BookDto;
import com.kitri.library.main.main.MainTest;
import com.kitri.library.main.start.StartTest;

public class Chart extends JFrame {

	private JPanel contentPane;
//	BarChartTest barChartTest;
//	ChartFactory
//	JFreeChart chart;
	private BufferedImage bufferedImage;
	public BookDao bookDao = BookDao.getInstance();

	JLabel lblChartImg;
	private ImageIcon icon;

	*//**
	 * Create the frame.
	 *//*
	public Chart() {

		barChartTest = new BarChartTest();
		barChartTest.setUp();
		uiInit();
		chart = createBarChart();

	}

	public void setToLabel(JLabel lblChartImg) {
		bufferedImage = chart.createBufferedImage(lblChartImg.getWidth(), lblChartImg.getHeight());
		Image resizeImage = bufferedImage.getScaledInstance(lblChartImg.getWidth(), lblChartImg.getHeight(),
				BufferedImage.SCALE_FAST);
		icon = new ImageIcon(resizeImage);
		lblChartImg.setIcon(icon);
	}

	void uiInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	*//**
	 * Create a bar chart with sample data in the range -3 to +3.
	 *
	 * @return The chart.
	 *//*
	private JFreeChart createBarChart() {
		HashMap<String, Integer> bookNameCount = new HashMap<String, Integer>();

		bookDao.setAllList();
		Vector<BookDto> bookList = bookDao.getList();
		int len = bookList.size();
		for (int i = 0; i < len; i++) {
			if (!bookList.get(i).getRenting().equals("no")) {
				String name = bookList.get(i).getName();
				if (bookNameCount.get(name) == null) {
					bookNameCount.put(name, 1);
				} else {
					bookNameCount.put(name, bookNameCount.get(name) + 1);
				}
			}
		} // end for
		
		
		// create a dataset...
		Number[][] data = new Integer[][] { { new Integer(-3), new Integer(-2) }, { new Integer(-1), new Integer(1) },
				{ new Integer(2), new Integer(3) } };

		CategoryDataset dataset = DatasetUtilities.createCategoryDataset("S", "C", data);

		// create the chart...
		JFreeChart jFreeChart = ChartFactory.createBarChart("ÀÎ±â µµ¼­", "µµ¼­ÀÌ¸§", "´ë¿©È½¼ö", dataset, PlotOrientation.VERTICAL,
				true, true, true);
		jFreeChart.getTitle().setFont(new Font("±¼¸²", Font.BOLD, 15));
		CategoryPlot plot = jFreeChart.getCategoryPlot();
		plot.getDomainAxis().setLabelFont(new Font("±¼¸²", Font.BOLD, 15));
		plot.getDomainAxis().setTickLabelFont(new Font("±¼¸²", Font.BOLD, 15));
		plot.getRangeAxis().setLabelFont(new Font("±¼¸²", Font.BOLD, 15));
		plot.getRangeAxis().setTickLabelFont(new Font("±¼¸²", Font.BOLD, 15));
		return jFreeChart;
	}// end createBarChart()

}*/
