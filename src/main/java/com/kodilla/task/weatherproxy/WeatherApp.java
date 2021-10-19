package com.kodilla.task.weatherproxy;

import java.util.Random;

public class WeatherApp {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread () {
            public void run () {
                System.out.println("Starting thread 1");
                long begin = System.currentTimeMillis();

                for (int n = 0; n < 5; n++) {
                    WeatherForecastProvider weatherForecastProvider = null;
                    try {
                        weatherForecastProvider = new WeatherComForecastClient();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int number = new Random().nextInt(100);
                    if (number < 20) {
                        try {
                            System.out.println(weatherForecastProvider.refreshData());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if (number < 30) {
                        try {
                            System.out.println(weatherForecastProvider.getWeather());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Execution #" + n + " just finished");
                }

                long end = System.currentTimeMillis();
                System.out.println("The execution in thread 1 took: " + (end - begin) + " [ms]");
            }
        };
        Thread thread2 = new Thread () {
            public void run () {
                System.out.println("Starting thread 2");
                long begin = System.currentTimeMillis();

                for (int n = 0; n < 5; n++) {
                    WeatherForecastProvider weatherForecastProvider = new WeatherForecastProviderProxy();
                    int number = new Random().nextInt(100);
                    if (number < 20) {
                        try {
                            System.out.println(weatherForecastProvider.refreshData());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if (number < 30) {
                        try {
                            System.out.println(weatherForecastProvider.getWeather());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Execution #" + n + " just finished");
                }

                long end = System.currentTimeMillis();
                System.out.println("The execution in thread 2 took: " + (end - begin) + " [ms]");
            }
        };
        thread1.start();
        thread2.start();

    }
}

