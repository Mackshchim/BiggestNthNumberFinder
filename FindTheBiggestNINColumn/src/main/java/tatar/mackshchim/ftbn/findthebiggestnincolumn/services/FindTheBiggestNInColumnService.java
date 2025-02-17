package tatar.mackshchim.ftbn.findthebiggestnincolumn.services;

import org.springframework.stereotype.Service;


public interface FindTheBiggestNInColumnService {

    double findTheBiggestNInColumnOfTheFile(String xlsxFilepath, int N);
}
