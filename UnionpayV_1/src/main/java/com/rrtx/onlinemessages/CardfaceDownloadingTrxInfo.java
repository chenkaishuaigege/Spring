package com.rrtx.onlinemessages;


import com.rrtx.util.JavaUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenkai
 *
 * 
 */
public class CardfaceDownloadingTrxInfo implements Serializable {

    String cardfaceID;
    String cardfaceType;
    String panPosX;
    String panPosY;
    String panFontSize;
    String color;
    String cardfaceData;


    public Builder builder() {
        return new Builder();
    }

    public class Builder {

        CardfaceDownloadingTrxInfo cardfaceDownloadingTrxInfo = new CardfaceDownloadingTrxInfo();

        public CardfaceDownloadingTrxInfo createEntity() {
            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(cardfaceID)) {
                cardfaceDownloadingTrxInfo.setCardfaceID(cardfaceID);
            }
            return cardfaceDownloadingTrxInfo;
        }
        public Builder setCardfaceID(String cardfaceID_) {
            cardfaceID = cardfaceID_;
            cardfaceDownloadingTrxInfo.setCardfaceID(cardfaceID);
            return this;
        }
    }


    private void setCardfaceID(String cardfaceID) {
        this.cardfaceID = cardfaceID;
    }

    private void setCardfaceType(String cardfaceType) {
        this.cardfaceType = cardfaceType;
    }

    private void setPanPosX(String panPosX) {
        this.panPosX = panPosX;
    }

    private void setPanPosY(String panPosY) {
        this.panPosY = panPosY;
    }

    private void setPanFontSize(String panFontSize) {
        this.panFontSize = panFontSize;
    }

    private void setColor(String color) {
        this.color = color;
    }

    private void setCardfaceData(String cardfaceData) {
        this.cardfaceData = cardfaceData;
    }

    public String getCardfaceID() {
        return cardfaceID;
    }

    public String getCardfaceType() {
        return cardfaceType;
    }

    public String getPanPosX() {
        return panPosX;
    }

    public String getPanPosY() {
        return panPosY;
    }

    public String getPanFontSize() {
        return panFontSize;
    }

    public String getColor() {
        return color;
    }

    public String getCardfaceData() {
        return cardfaceData;
    }

    @Override
    public String toString() {
        return "CardfaceDownloadingTrxInfo{" +
                "cardfaceID='" + cardfaceID + '\'' +
                ", cardfaceType='" + cardfaceType + '\'' +
                ", panPosX='" + panPosX + '\'' +
                ", panPosY='" + panPosY + '\'' +
                ", panFontSize='" + panFontSize + '\'' +
                ", color='" + color + '\'' +
                ", cardfaceData='" + cardfaceData + '\'' +
                '}';
    }
}
