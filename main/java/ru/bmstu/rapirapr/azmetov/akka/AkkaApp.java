package ru.bmstu.rapirapr.azmetov.akka;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class DelaysStatisticsApp {
    public static final String JOB_NAME = "DelaysStatisticsApp";
    public static final String USAGE_ERROR_TEXT = "Usage: ru.bmstu.rapirapr.azmetov.delays.DelaysStatistics <input1 path> <input2 path> <output path>";

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println(USAGE_ERROR_TEXT);
            System.exit(-1);
        } frefrefr

        Job job = Job.getInstance();
        job.setJarByClass(DelaysStatisticsApp.class);
        job.setJobName(JOB_NAME);
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, AirportsJoinMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, FlightsJoinMapper.class);
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        job.setPartitionerClass(AirportIdHashPartitioner.class);
        job.setGroupingComparatorClass(AirportIdComparator.class);
        job.setReducerClass(JoinReducer.class);
        job.setMapOutputKeyClass(KeyWritable.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}