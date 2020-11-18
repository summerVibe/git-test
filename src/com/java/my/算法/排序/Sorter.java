package my.算法.排序;

import java.util.Comparator;

/**
 * @author  : J
 * @version : Jun 29, 2017  11:09:23 AM
 * explain  : 
 */
public interface Sorter {

	/**
    * 排序
    * @param list 待排序的数组
    */
   public <T extends Comparable<T>> void sort(T[] list);

   /**
    * 排序
    * @param list 待排序的数组
    * @param comp 比较两个对象的比较器
    */
   public <T> void sort(T[] list, Comparator<T> comp);
}
