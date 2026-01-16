/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package org.bhaduri.tarang.callvalidation;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.bhaduri.tarang.DTO.ValidateCall;
import org.bhaduri.tarang.DTO.ValidationSummaryDTO;
import org.bhaduri.tarang.services.MasterDataServices;
import software.xdev.chartjs.model.charts.DoughnutChart;
import software.xdev.chartjs.model.data.DoughnutData;
import software.xdev.chartjs.model.dataset.DoughnutDataset;
import software.xdev.chartjs.model.options.DoughnutOptions;
import java.math.BigDecimal;
import software.xdev.chartjs.model.color.Color;
import software.xdev.chartjs.model.options.Plugins;
import software.xdev.chartjs.model.options.Title;


/**
 *
 * @author sb
 */
@Named(value = "validationSummary")
@ViewScoped
public class ValidationSummary implements Serializable {

    private String selectedScrip;
    private String scripName;
    private List<ValidationSummaryDTO> report;
    private String callOneSuccFail;
    private String callOneRanges;
    private String callTwoSuccFail;
    private String callTwoRanges;

    /**
     * Creates a new instance of ValidationSummary
     */
    public ValidationSummary() {
    }

    public void fillValues() throws NamingException {
        MasterDataServices masterDataService = new MasterDataServices();
        report = new ArrayList<>();
        List<ValidateCall> callsperscrip = masterDataService.getCallsPerScrip(selectedScrip);

        String callone;
        String calltwo;
        double price;
        double diff;
        int failcountone = 0;
        int nacountone = 0;
        int rangeonecountone = 0;
        int rangetwocountone = 0;
        int rangethreecountone = 0;

        int failcounttwo = 0;
        int nacounttwo = 0;
        int rangeonecounttwo = 0;
        int rangetwocounttwo = 0;
        int rangethreecounttwo = 0;
        for (int i = 0; i < callsperscrip.size(); i++) {
            callone = callsperscrip.get(i).getCallOne();
            calltwo = callsperscrip.get(i).getCallTwo();
            price = callsperscrip.get(i).getPrice();

            if ((callone.equals("buy") && calltwo.equals("buy"))
                    || (callone.equals("sell") && calltwo.equals("sell"))) {
                if (callsperscrip.get(i).getOutcomeOne().equals("fail")) {
                    failcountone = failcountone + 1;
                    failcounttwo = failcounttwo + 1;
                } else {
                    diff = Math.abs(callsperscrip.get(i).getActualPriceOne() - price);
                    if ((diff / price) <= ((0.2 / 100) * price)) {
                        rangeonecountone = rangeonecountone + 1;
                        rangeonecounttwo = rangeonecounttwo + 1;
                    }
                    if ((((0.2 / 100) * price) < (diff / price))
                            && ((diff / price) <= ((0.4 / 100) * price))) {
                        rangetwocountone = rangetwocountone + 1;
                        rangetwocounttwo = rangetwocounttwo + 1;
                    }
                    if ((diff / price) > ((0.4 / 100) * price)) {
                        rangethreecountone = rangethreecountone + 1;
                        rangethreecounttwo = rangethreecounttwo + 1;
                    }
                }
            }
//     ###############################       
            if ((callone.equals("buy") && calltwo.equals("sell"))
                    || (callone.equals("sell") && calltwo.equals("buy"))) {
                if ((callsperscrip.get(i).getOutcomeOne().equals("fail"))
                        || (callsperscrip.get(i).getOutcomeTwo().equals("fail"))) {
                    if (callsperscrip.get(i).getOutcomeOne().equals("fail")) {
                        failcountone = failcountone + 1;
                    }
                    if (callsperscrip.get(i).getOutcomeTwo().equals("fail")) {
                        failcounttwo = failcounttwo + 1;
                    }

                }
                if ((callsperscrip.get(i).getOutcomeOne().equals("pass"))
                        || (callsperscrip.get(i).getOutcomeTwo().equals("pass"))) {
                    if (callsperscrip.get(i).getOutcomeOne().equals("pass")) {
                        diff = Math.abs(callsperscrip.get(i).getActualPriceOne() - price);
                        if ((diff / price) <= ((0.2 / 100) * price)) {
                            rangeonecountone = rangeonecountone + 1;
                        }
                        if ((((0.2 / 100) * price) < (diff / price))
                                && ((diff / price) <= ((0.4 / 100) * price))) {
                            rangetwocountone = rangetwocountone + 1;
                        }
                        if ((diff / price) > ((0.4 / 100) * price)) {
                            rangethreecountone = rangethreecountone + 1;
                        }
                    }
                    if (callsperscrip.get(i).getOutcomeTwo().equals("pass")) {
                        diff = Math.abs(callsperscrip.get(i).getActualPriceTwo() - price);
                        if ((diff / price) <= ((0.2 / 100) * price)) {
                            rangeonecounttwo = rangeonecounttwo + 1;
                        }
                        if ((((0.2 / 100) * price) < (diff / price))
                                && ((diff / price) <= ((0.4 / 100) * price))) {
                            rangetwocounttwo = rangetwocounttwo + 1;
                        }
                        if ((diff / price) > ((0.4 / 100) * price)) {
                            rangethreecounttwo = rangethreecounttwo + 1;
                        }
                    }
                }
            }
//     ###############################
            if ((callone.equals("buy") && calltwo.equals("no"))
                    || (callone.equals("sell") && calltwo.equals("no"))) {
                nacounttwo = nacounttwo + 1;
                if (callsperscrip.get(i).getOutcomeOne().equals("fail")) {
                    failcountone = failcountone + 1;
                } else {
                    diff = Math.abs(callsperscrip.get(i).getActualPriceOne() - price);
                    if ((diff / price) <= ((0.2 / 100) * price)) {
                        rangeonecountone = rangeonecountone + 1;
                    }
                    if ((((0.2 / 100) * price) < (diff / price))
                            && ((diff / price) <= ((0.4 / 100) * price))) {
                        rangetwocountone = rangetwocountone + 1;
                    }
                    if ((diff / price) > ((0.4 / 100) * price)) {
                        rangethreecountone = rangethreecountone + 1;
                    }
                }
            }
//     ###############################
            if ((callone.equals("no") && calltwo.equals("buy"))
                    || (callone.equals("no") && calltwo.equals("sell"))) {
                nacountone = nacountone + 1;
                if (callsperscrip.get(i).getOutcomeTwo().equals("fail")) {
                    failcounttwo = failcounttwo + 1;
                } else {
                    diff = Math.abs(callsperscrip.get(i).getActualPriceTwo() - price);
                    if ((diff / price) <= ((0.2 / 100) * price)) {
                        rangeonecounttwo = rangeonecounttwo + 1;
                    }
                    if ((((0.2 / 100) * price) < (diff / price))
                            && ((diff / price) <= ((0.4 / 100) * price))) {
                        rangetwocounttwo = rangetwocounttwo + 1;
                    }
                    if ((diff / price) > ((0.4 / 100) * price)) {
                        rangethreecounttwo = rangethreecounttwo + 1;
                    }
                }
            }
//     ###############################            
            if (callone.equals("no") && calltwo.equals("no")) {
                nacountone = nacountone + 1;
                nacounttwo = nacounttwo + 1;
            }
        } //for loop for a single scrip
        double ratio = (double) rangeonecountone / callsperscrip.size();
        String formattedRatio = String.format("%.2f", ratio * 100);
        ValidationSummaryDTO reportRecord = new ValidationSummaryDTO();
        reportRecord.setHeading("0-0.2(%)");
        reportRecord.setCallOneCount(String.valueOf(rangeonecountone));
        reportRecord.setCallOnePercent(formattedRatio + "%");
        ratio = (double) rangeonecounttwo / callsperscrip.size();
        formattedRatio = String.format("%.2f", ratio * 100);
        reportRecord.setCallTwoCount(String.valueOf(rangeonecounttwo));
        reportRecord.setCallTwoPercent(formattedRatio + "%");
        report.add(reportRecord);

        ratio = (double) rangetwocountone / callsperscrip.size();
        formattedRatio = String.format("%.2f", ratio * 100);
        reportRecord = new ValidationSummaryDTO();
        reportRecord.setHeading("0.2-0.4(%)");
        reportRecord.setCallOneCount(String.valueOf(rangetwocountone));
        reportRecord.setCallOnePercent(formattedRatio + "%");
        ratio = (double) rangetwocounttwo / callsperscrip.size();
        formattedRatio = String.format("%.2f", ratio * 100);
        reportRecord.setCallTwoCount(String.valueOf(rangetwocounttwo));
        reportRecord.setCallTwoPercent(formattedRatio + "%");
        report.add(reportRecord);

        ratio = (double) rangethreecountone / callsperscrip.size();
        formattedRatio = String.format("%.2f", ratio * 100);
        reportRecord = new ValidationSummaryDTO();
        reportRecord.setHeading("> 0.4(%)");
        reportRecord.setCallOneCount(String.valueOf(rangethreecountone));
        reportRecord.setCallOnePercent(formattedRatio + "%");
        ratio = (double) rangethreecounttwo / callsperscrip.size();
        formattedRatio = String.format("%.2f", ratio * 100);
        reportRecord.setCallTwoCount(String.valueOf(rangethreecounttwo));
        reportRecord.setCallTwoPercent(formattedRatio + "%");
        report.add(reportRecord);

        ratio = (double) nacountone / callsperscrip.size();
        formattedRatio = String.format("%.2f", ratio * 100);
        reportRecord = new ValidationSummaryDTO();
        reportRecord.setHeading("Undefined");
        reportRecord.setCallOneCount(String.valueOf(nacountone));
        reportRecord.setCallOnePercent(formattedRatio + "%");
        ratio = (double) nacounttwo / callsperscrip.size();
        formattedRatio = String.format("%.2f", ratio * 100);
        reportRecord.setCallTwoCount(String.valueOf(nacounttwo));
        reportRecord.setCallTwoPercent(formattedRatio + "%");
        report.add(reportRecord);

        ratio = (double) failcountone / callsperscrip.size();
        formattedRatio = String.format("%.2f", ratio * 100);
        reportRecord = new ValidationSummaryDTO();
        reportRecord.setHeading("Failed");
        reportRecord.setCallOneCount(String.valueOf(failcountone));
        reportRecord.setCallOnePercent(formattedRatio + "%");
        ratio = (double) failcounttwo / callsperscrip.size();
        formattedRatio = String.format("%.2f", ratio * 100);
        reportRecord.setCallTwoCount(String.valueOf(failcounttwo));
        reportRecord.setCallTwoPercent(formattedRatio + "%");
        report.add(reportRecord);

        ratio = (double) (rangeonecountone + rangetwocountone + rangethreecountone)
                / callsperscrip.size();
        formattedRatio = String.format("%.2f", ratio * 100);

        reportRecord = new ValidationSummaryDTO();
        reportRecord.setHeading("Total Success");
        reportRecord.setCallOneCount("--");
        reportRecord.setCallOnePercent(formattedRatio + "%");
        reportRecord.setCallTwoCount("--");
        ratio = (double) (rangeonecounttwo + rangetwocounttwo + rangethreecounttwo)
                / callsperscrip.size();
        formattedRatio = String.format("%.2f", ratio * 100);

        reportRecord.setCallTwoPercent(formattedRatio + "%");
        report.add(reportRecord);

//     ###############################  
        callOneSuccFail = new DoughnutChart()
                .setData(new DoughnutData()
                        .addDataset(new DoughnutDataset()
                                .setData(BigDecimal.valueOf(rangeonecountone + rangetwocountone + rangethreecountone),
                                        BigDecimal.valueOf(failcountone),
                                        BigDecimal.valueOf(nacountone))
                                .addBackgroundColors(
                                        new Color(7, 117, 18),
                                        new Color(252, 3, 19),
                                        new Color(255, 205, 86))
                        )
                        .setLabels("Success", "Failure", "Undefined")
                )
                .setOptions(new DoughnutOptions()
                        .setMaintainAspectRatio(Boolean.FALSE)
                        .setPlugins(new Plugins()
                                .setTitle(new Title()
                                        .setDisplay(true)
                                        .setText("Raw-fibo Fractal Success Failures") // Set your title text here
                                        .setFontSize(25) // Optional: Set font size
                                )
                        )
                )
                .toJson();
        
        
        callOneRanges = new DoughnutChart()
                .setData(new DoughnutData()
                        .addDataset(new DoughnutDataset()
                                .setData(BigDecimal.valueOf(rangeonecountone),
                                        BigDecimal.valueOf(rangetwocountone),
                                        BigDecimal.valueOf(rangethreecountone))
                                .addBackgroundColors(
                                        new Color(255, 99, 132),
                                        new Color(54, 162, 235),
                                        new Color(255, 205, 86))
                        )
                        
                        .setLabels("0-0.2(%)", "0.2-0.4(%)", "> 0.4(%)")
                )
                .setOptions(new DoughnutOptions()
                        .setMaintainAspectRatio(Boolean.FALSE)
                        .setPlugins(new Plugins()
                                .setTitle(new Title()
                                        .setDisplay(true)
                                        .setText("Range-wise Raw-fibo Fractal Success Calls") // Set your title text here
                                        .setFontSize(25) // Optional: Set font size
                                )
                        )
                )
                .toJson();
        
        
        callTwoSuccFail = new DoughnutChart()
                .setData(new DoughnutData()
                        .addDataset(new DoughnutDataset()
                                .setData(BigDecimal.valueOf(rangeonecounttwo + 
                                        rangetwocounttwo + rangethreecounttwo),
                                        BigDecimal.valueOf(failcounttwo),
                                        BigDecimal.valueOf(nacounttwo))
                                .addBackgroundColors(
                                        new Color(7, 117, 18),
                                        new Color(252, 3, 19),
                                        new Color(255, 205, 86))
                        )
                        .setLabels("Success", "Failure", "Undefined")
                )
                .setOptions(new DoughnutOptions()
                        .setMaintainAspectRatio(Boolean.FALSE)
                        .setPlugins(new Plugins()
                                .setTitle(new Title()
                                        .setDisplay(true)
                                        .setText("Tuned-fibo Fractal Success Failures") // Set your title text here
                                        .setFontSize(25) // Optional: Set font size
                                )
                        )
                )
                .toJson();
        
        
        callTwoRanges = new DoughnutChart()
                .setData(new DoughnutData()
                        .addDataset(new DoughnutDataset()
                                .setData(BigDecimal.valueOf(rangeonecounttwo),
                                        BigDecimal.valueOf(rangetwocounttwo),
                                        BigDecimal.valueOf(rangethreecounttwo))
                                .addBackgroundColors(
                                        new Color(255, 99, 132),
                                        new Color(54, 162, 235),
                                        new Color(255, 205, 86))
                        )
                        
                        .setLabels("0-0.2(%)", "0.2-0.4(%)", "> 0.4(%)")
                )
                .setOptions(new DoughnutOptions()
                        .setMaintainAspectRatio(Boolean.FALSE)
                        .setPlugins(new Plugins()
                                .setTitle(new Title()
                                        .setDisplay(true)
                                        .setText("Range-wise Tuned-fibo Fractal Success Calls") // Set your title text here
                                        .setFontSize(25) // Optional: Set font size
                                )
                        )
                )
                .toJson();
    }
    
    public String showDetails() {        
        String redirectUrl = "/secured/validationperscrip?faces-redirect=true&selectedScrip="+ 
               selectedScrip + "&scripName=" + scripName;
        return redirectUrl;
//        return "/secured/userhome";
    }
    
    public String getSelectedScrip() {
        return selectedScrip;
    }

    public void setSelectedScrip(String selectedScrip) {
        this.selectedScrip = selectedScrip;
    }

    public List<ValidationSummaryDTO> getReport() {
        return report;
    }

    public void setReport(List<ValidationSummaryDTO> report) {
        this.report = report;
    }

    public String getScripName() {
        return scripName;
    }

    public void setScripName(String scripName) {
        this.scripName = scripName;
    }

    public String getCallOneSuccFail() {
        return callOneSuccFail;
    }

    public void setCallOneSuccFail(String callOneSuccFail) {
        this.callOneSuccFail = callOneSuccFail;
    }

    public String getCallOneRanges() {
        return callOneRanges;
    }

    public void setCallOneRanges(String callOneRanges) {
        this.callOneRanges = callOneRanges;
    }

    public String getCallTwoSuccFail() {
        return callTwoSuccFail;
    }

    public void setCallTwoSuccFail(String callTwoSuccFail) {
        this.callTwoSuccFail = callTwoSuccFail;
    }

    public String getCallTwoRanges() {
        return callTwoRanges;
    }

    public void setCallTwoRanges(String callTwoRanges) {
        this.callTwoRanges = callTwoRanges;
    }

    

}
