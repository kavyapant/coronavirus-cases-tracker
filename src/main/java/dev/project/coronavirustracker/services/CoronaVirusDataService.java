package dev.project.coronavirustracker.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service //Tells Spring Create an instance of this class when application starts running
public class CoronaVirusDataService {

    private static String VIRUS_DATA_URL="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    @PostConstruct //Tells Spring to run this method once class has been instantiated
    @Scheduled(cron="* * 6 * * *",zone="GMT")// cron uses servers local time zone can be changed using zone attribute
    public void fetchVirusData() throws IOException, InterruptedException {
        HttpClient client= HttpClient.newHttpClient();
        HttpRequest request=HttpRequest.newBuilder().uri(URI.create(VIRUS_DATA_URL)).build();
        HttpResponse<String> httpResponse=client.send(request, HttpResponse.BodyHandlers.ofString());
        StringReader in = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {
            System.out.println(record.get("Province/State"));
        }
    }
}
