package ru.bmstu.rapirapr.azmetov.akka;


import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightsJoinMapper extends Mapper<LongWritable, Text, KeyWritable, Text> {
    public static final int AIRPORT_ID_COL_NUMBER = 14;
    public static final int DELAY_COL_NUMBER = 18;
    public static  final String CSV_DELIMITER = ",";
    public static final String QUOTE_SYMBOLS_REGEX = "\"";

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] csvColumns = value.toString().split(CSV_DELIMITER);
        String delay = csvColumns[DELAY_COL_NUMBER];
        if (Float.parseFloat(delay) != 0 && StringUtils.isNotBlank(delay)) {
            context.write(
                    new KeyWritable(removeQuotationSymbols(csvColumns[AIRPORT_ID_COL_NUMBER]), true),
                    new Text(delay)
            );
        }
    }

    private String removeQuotationSymbols(String s) {
        return s.replaceAll(QUOTE_SYMBOLS_REGEX, "");
    }
}