/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.phim;


import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author Acer
 */
public class DoTuoiRender extends BasicComboBoxRenderer{
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

            if(value != null)

        {

        //Lấy đối tượng khoa

        DoTuoi objTuoi = (DoTuoi)value;

        //Hiển thị lại nội dung

        setText(objTuoi.getDoTuoi());
    }

        return this;

        }    
}
