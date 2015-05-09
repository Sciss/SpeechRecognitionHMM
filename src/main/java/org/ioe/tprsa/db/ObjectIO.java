/*
  Please feel free to use/modify this class. 
  If you give me credit by keeping this information or
  by sending me an email before using it or by reporting bugs , i will be happy.
  Email : gtiwari333@gmail.com,
  Blog : http://ganeshtiwaridotcomdotnp.blogspot.com/ 
 */
package org.ioe.tprsa.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This Class works for both any object <code><T></code>, which implements the
 * Model interface
 * 
 * @author Ganesh Tiwari
 * 
 * @param <T>
 */
public class ObjectIO<T> {

	private ObjectInputStream input;
	private ObjectOutputStream output;
	T model;

	/**
	 * default constructor of modelDB
	 */
	public ObjectIO() {
	}

	/**
	 * sets the model to save to db
	 * 
	 * @param model
	 *            model of current type to save into db
	 */
	public void setModel(T model) {
		this.model = model;
	}

	/**
	 * saves the model to {@code filePath} of type T
	 * 
	 * @param filePath
	 */
	public void saveModel(String filePath) {
		// open file
		try {
			output = new ObjectOutputStream(new FileOutputStream(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found, while saving model");
		} catch (IOException e) {
			System.out.println("Some IO Exception, while opening file, for saving");
		}
		// save model
		try {
			output.writeObject(model);
			output.close();
		} catch (IOException e) {
			System.out.println("IOException, error on writing model to file");
			e.printStackTrace();
		}
	}

	/**
	 * read the model from {@code filePath} of type T
	 * 
	 * @param filePath
	 * @return the model of type T
	 */
	public T readModel(String filePath) {
		// open file
		try {
			input = new ObjectInputStream(new FileInputStream(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found, while reading model");
		} catch (IOException e) {
			System.out.println("Some IO Exception, while opening file");
		}
		// read
		try {
			model = (T) input.readObject();
			input.close();
		} catch (IOException e) {
			System.out.println("Some IO Exception, while reading object from file");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found, error on type cast");
		} catch (NullPointerException e) {
			System.out.println("new user we guess");
			return null;
		}
		return model;
	}
}
