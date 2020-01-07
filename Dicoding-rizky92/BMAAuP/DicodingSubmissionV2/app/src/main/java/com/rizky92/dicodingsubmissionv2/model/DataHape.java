package com.rizky92.dicodingsubmissionv2.model;

import com.rizky92.dicodingsubmissionv2.R;

import java.util.ArrayList;

public class DataHape {
    private static String[] Xiaomi = {
            "Redmi Note 8 Pro",
            "Redmi Note 8",
            "Redmi 8",
            "Redmi 8A",
            "Redmi Note 7 Pro",
            "Redmi Note 7",
            "Redmi 7",
            "Redmi 7A",
            "Redmi K20 Pro Premium",
            "Redmi K20 Pro",
            "Redmi K20"
    };

    private static String[] Announced = {
            "2019, August",
            "2019, August",
            "2019, October",
            "2019, September",
            "2019, February",
            "2019, January",
            "2019, March",
            "2019, May",
            "2019, September",
            "2019, May",
            "2019, May"
    };

    private static String[] Status = {
            "Available. Released 2019, September",
            "Available. Released 2019, September",
            "Available. Released 2019, October",
            "Available. Released 2019, September",
            "Available. Released 2019, March",
            "Available. Released 2019, January",
            "Available. Released 2019, March",
            "Available. Released 2019, June",
            "Available. Released 2019, September",
            "Available. Released 2019, June",
            "Available. Released 2019, June"
    };

    private static String[] Network = {
            "GSM / HSPA / LTE",
            "GSM / HSPA / LTE",
            "GSM / HSPA / LTE",
            "GSM / HSPA / LTE",
            "GSM / HSPA / LTE",
            "GSM / HSPA / LTE",
            "GSM / CDMA / HSPA / LTE",
            "GSM / HSPA / LTE",
            "GSM / HSPA / LTE",
            "GSM / HSPA / LTE",
            "GSM / HSPA / LTE"
    };

    private static String[] Dimensions = {
            "161.4 x 76.4 x 8.8 mm (6.35 x 3.01 x 0.35 in)",
            "158.3 x 75.3 x 8.4 mm (6.23 x 2.96 x 0.33 in)",
            "156.5 x 75.4 x 9.4 mm (6.16 x 2.97 x 0.37 in)",
            "156.5 x 75.4 x 9.4 mm (6.16 x 2.97 x 0.37 in)",
            "159.2 x 75.2 x 8.1 mm (6.27 x 2.96 x 0.32 in)",
            "159.2 x 75.2 x 8.1 mm (6.27 x 2.96 x 0.32 in)",
            "158.7 x 75.6 x 8.5 mm (6.25 x 2.98 x 0.33 in)",
            "146.3 x 70.4 x 9.6 mm (5.76 x 2.77 x 0.38 in)",
            "156.7 x 74.3 x 8.8 mm (6.17 x 2.93 x 0.35 in)",
            "156.7 x 74.3 x 8.8 mm (6.17 x 2.93 x 0.35 in)",
            "156.7 x 74.3 x 8.8 mm (6.17 x 2.93 x 0.35 in)"
    };

    private static String[] Weight = {
            "200 g (7.05 oz)",
            "190 g (6.70 oz)",
            "188 g (6.63 oz)",
            "188 g (6.63 oz)",
            "186 g (6.56 oz)",
            "186 g (6.56 oz)",
            "180 g (6.35 oz)",
            "165 g (5.82 oz)",
            "191 g (6.74 oz)",
            "191 g (6.74 oz)",
            "191 g (6.74 oz)"
    };

    private static String[] Build = {
            "Front/back glass (Gorilla Glass 5)",
            "Front/back glass (Gorilla Glass 5)",
            "Unknown Build",
            "Front glass, plastic body",
            "Front/back glass (Gorilla Glass 5)",
            "Front/back glass (Gorilla Glass 5), plastic frame",
            "Unknown Build",
            "Front glass, plastic body",
            "Front/back glass (Gorilla Glass 5), aluminum frame",
            "Front/back glass (Gorilla Glass 5), aluminum frame",
            "Front/back glass, aluminum frame"
    };

    private static String[] SIM = {
            "Hybrid Dual SIM (Nano-SIM, dual stand-by)",
            "Dual SIM (Nano-SIM, dual stand-by)",
            "Dual SIM (Nano-SIM, dual stand-by)",
            "Dual SIM (Nano-SIM, dual stand-by)",
            "Hybrid Dual SIM (Nano-SIM, dual stand-by)",
            "Hybrid Dual SIM (Nano-SIM, dual stand-by)",
            "Dual SIM (Nano-SIM, dual stand-by)",
            "Dual SIM (Nano-SIM, dual stand-by)",
            "Dual SIM (Nano-SIM, dual stand-by)",
            "Dual SIM (Nano-SIM, dual stand-by)",
            "Dual SIM (Nano-SIM, dual stand-by)"
    };

    private static String[] Type = {
            "IPS LCD capacitive touchscreen, 16M colors",
            "IPS LCD capacitive touchscreen, 16M colors",
            "IPS LCD capacitive touchscreen, 16M colors",
            "IPS LCD capacitive touchscreen, 16M colors",
            "IPS LCD capacitive touchscreen, 16M colors",
            "IPS LCD capacitive touchscreen, 16M colors",
            "IPS LCD capacitive touchscreen, 16M colors",
            "IPS LCD capacitive touchscreen, 16M colors",
            "Super AMOLED capacitive touchscreen, 16M colors, DCI-P3 100%, HDR10",
            "Super AMOLED capacitive touchscreen, 16M colors, DCI-P3 100%, HDR10",
            "Super AMOLED capacitive touchscreen, 16M colors, HDR"
    };

    private static String[] Size = {
            "6.53 inches, 104.7 cm2 (~84.9% screen-to-body ratio)",
            "6.3 inches, 97.4 cm2 (~81.7% screen-to-body ratio)",
            "6.22 inches, 96.6 cm2 (~81.8% screen-to-body ratio)",
            "6.2 inches, 95.9 cm2 (~81.3% screen-to-body ratio)",
            "6.3 inches, 97.4 cm2 (~81.4% screen-to-body ratio)",
            "6.3 inches, 97.4 cm2 (~81.4% screen-to-body ratio)",
            "6.26 inches, 97.8 cm2 (~81.5% screen-to-body ratio)",
            "5.45 inches, 76.7 cm2 (~74.4% screen-to-body ratio)",
            "6.39 inches, 100.2 cm2 (~86.1% screen-to-body ratio)",
            "6.39 inches, 100.2 cm2 (~86.1% screen-to-body ratio)",
            "6.39 inches, 100.2 cm2 (~86.1% screen-to-body ratio)"
    };

    private static String[] Resolution = {
            "1080 x 2340 pixels, 19.5:9 ratio (~395 ppi density)",
            "1080 x 2340 pixels, 19.5:9 ratio (~409 ppi density)",
            "720 x 1520 pixels, 19:9 ratio (~270 ppi density)",
            "720 x 1520 pixels, 19:9 ratio (~271 ppi density)",
            "1080 x 2340 pixels, 19.5:9 ratio (~409 ppi density)",
            "1080 x 2340 pixels, 19.5:9 ratio (~409 ppi density)",
            "720 x 1520 pixels, 19:9 ratio (~269 ppi density)",
            "720 x 1440 pixels, 18:9 ratio (~295 ppi density)",
            "1080 x 2340 pixels, 19.5:9 ratio (~403 ppi density)",
            "1080 x 2340 pixels, 19.5:9 ratio (~403 ppi density)",
            "1080 x 2340 pixels, 19.5:9 ratio (~403 ppi density)"
    };

    private static String[] OS = {
            "Android 9.0 (Pie); MIUI 10",
            "Android 9.0 (Pie); MIUI 10",
            "Android 9.0 (Pie); MIUI 10",
            "Android 9.0 (Pie); MIUI 10",
            "Android 9.0 (Pie), upgradable to Android 10; MIUI 11",
            "Android 9.0 (Pie); MIUI 10",
            "Android 7.0 (Nougat), upgradable to Android 10; MIUI 11",
            "Android 9.0 (Pie); MIUI 10.2.7",
            "Android 10; MIUI 11",
            "Android 9.0 (Pie); MIUI 10",
            "Android 9.0 (Pie), upgradable to Android 10; MIUI 11",
    };

    private static String[] Chipset = {
            "Mediatek Helio G90T (12nm)",
            "Qualcomm SDM665 Snapdragon 665 (11 nm)",
            "Qualcomm SDM439 Snapdragon 439 (12 nm)",
            "Qualcomm SDM439 Snapdragon 439 (12 nm)",
            "Qualcomm SDM675 Snapdragon 675 (11 nm)",
            "Qualcomm SDM660 Snapdragon 660 (14 nm)",
            "Qualcomm SDM632 Snapdragon 632 (14 nm)",
            "Qualcomm SDM439 Snapdragon 439 (12 nm)",
            "Qualcomm SDM855 Snapdragon 855+ (7 nm)",
            "Qualcomm SDM855 Snapdragon 855 (7 nm)",
            "Qualcomm SDM730 Snapdragon 730 (8 nm)"
    };

    private static String[] CPU = {
            "Octa-core (2x2.05 GHz Cortex-A76 & 6x2.0 GHz Cortex-A55)",
            "Octa-core (4x2.0 GHz Kryo 260 Gold & 4x1.8 GHz Kryo 260 Silver)",
            "Octa-core (2x1.95 GHz Cortex-A53 & 6x1.45 GHz Cortex A53)",
            "Octa-core (2x1.95 GHz Cortex-A53 & 6x1.45 GHz Cortex A53)",
            "Octa-core (2x2.0 GHz Kryo 460 Gold & 6x1.7 GHz Kryo 460 Silver)",
            "Octa-core (4x2.2 GHz Kryo 260 & 4x1.8 GHz Kryo 260)",
            "Octa-core (4x1.8 GHz Kryo 250 Gold & 4x1.8 GHz Kryo 250 Silver)",
            "Octa-core (2x2.0 GHz Cortex-A53 & 6x1.45 GHz Cortex A53)",
            "Octa-core (1x2.96 GHz Kryo 485 & 3x2.42 GHz Kryo 485 & 4x1.8 GHz Kryo 485)",
            "Octa-core (1x2.84 GHz Kryo 485 & 3x2.42 GHz Kryo 485 & 4x1.78 GHz Kryo 485)",
            "Octa-core (2x2.2 GHz Kryo 470 Gold & 6x1.8 GHz Kryo 470 Silver)"
    };

    private static String[] GPU = {
            "Mali-G76 MC4",
            "Adreno 610",
            "Adreno 505",
            "Adreno 505",
            "Adreno 612",
            "Adreno 512",
            "Adreno 506",
            "Adreno 505",
            "Adreno 640 (700 MHz)",
            "Adreno 640",
            "Adreno 618"
    };

    private static String[] RAM = {
            "6GB / 8GB",
            "3 GB / 4 GB / 6 GB",
            "3 GB / 4 GB",
            "2 GB / 3 GB",
            "4 GB / 6 GB",
            "3 GB / 4 GB / 6 GB",
            "2 GB / 3 GB / 4 GB",
            "2 GB / 3 GB",
            "8 GB / 12 GB",
            "6 GB / 8 GB",
            "6 GB / 8 GB"
    };

    private static String[] Internal = {
            "64 GB / 128 GB UFS2.1",
            "32 GB / 64 GB / 128 GB",
            "32 GB / 64 GB",
            "32 GB",
            "64 GB / 128 GB",
            "32 GB / 64 GB / 128 GB",
            "16 GB / 32 GB / 64 GB",
            "16 GB / 32 GB",
            "128 GB / 512 GB UFS2.1",
            "64 GB / 128 GB / 256 GB UFS2.1",
            "64 GB / 128 GB / 256 GB UFS2.1"
    };

    private static String[] External = {
            "Up to 256 GB",
            "Up to 256 GB",
            "Up to 512 GB",
            "Up to 512 GB",
            "Up to 256 GB",
            "Up to 256 GB",
            "Up to 1 TB",
            "Up to 256 GB",
            "No External Storage",
            "No External Storage",
            "No External Storage"
    };

    private static String[] rearCamera = {
            "64 MP Main + 8 MP Ultrawide + 2 MP Macro + 2 MP Depth Sensor",
            "48 MP Main + 8 MP Ultrawide + 2 MP Macro + 2 MP Depth Sensor",
            "12 MP Main + 2 MP Depth Sensor",
            "12 MP Main",
            "48 MP Main + 5 MP Depth Sensor",
            "48 MP Main + 5 MP Depth Sensor / 12 MP Main + 2 MP Depth Sensor",
            "12 MP Main + 2 MP Depth Sensor",
            "13 MP Main (China) / 12 MP Main",
            "48 MP Main + 13 MP Ultrawide + 8 MP Telephoto",
            "48 MP Main + 13 MP Ultrawide + 8 MP Telephoto",
            "48 MP Main + 13 MP Ultrawide + 8 MP Telephoto"
    };

    private static String[] rearFeatures = {
            "LED flash, HDR, panorama",
            "LED flash, HDR, panorama",
            "LED flash, HDR, panorama",
            "LED flash, HDR",
            "Dual-LED flash, HDR, panorama",
            "Dual-LED flash, HDR, panorama",
            "LED flash, HDR, panorama",
            "LED flash, HDR",
            "Dual-LED flash, HDR, panorama",
            "Dual-LED flash, HDR, panorama",
            "Dual-LED flash, HDR, panorama"
    };

    private static String[] rearVideo = {
            "2160p@30fps, 1080p@30/60/120fps, 720p@960fps, gyro-EIS",
            "2160p@30fps, 1080p@30/60/120fps, gyro-EIS",
            "1080p@30fps",
            "1080p@30fps",
            "2160p@30fps, 1080p@30/60/120fps, (gyro-EIS)",
            "1080p@30/60/120fps, (gyro-EIS)",
            "1080p@30/60fps",
            "1080p@30fps",
            "2160p@30/60fps, 1080p@30/120/240fps, 1080p@960fps",
            "2160p@30/60fps, 1080p@30/120/240fps, 1080p@960fps",
            "2160p@30fps, 1080p@30/120/240fps, 1080p@960fps"
    };

    private static String[] frontCamera = {
            "20 MP",
            "13 MP",
            "8 MP",
            "8 MP",
            "13 MP",
            "13 MP",
            "8 MP",
            "5 MP",
            "Motorized pop-up 20 MP",
            "Motorized pop-up 20 MP",
            "Motorized pop-up 20 MP"
    };

    private static String[] frontFeatures = {
            "HDR, panorama",
            "HDR, panorama",
            "HDR",
            "HDR",
            "HDR",
            "HDR",
            "HDR",
            "HDR",
            "HDR",
            "HDR",
            "HDR"
    };

    private static String[] frontVideo = {
            "1080p@30fps",
            "1080p@30fps",
            "1080p@30fps",
            "1080p@30fps",
            "1080p@30fps",
            "1080p@30fps",
            "1080p@30fps",
            "1080p@30fps",
            "1080p@30fps",
            "1080p@30fps",
            "1080p@30fps"
    };

    private static String[] Speaker = {
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes"
    };

    private static String[] Jack = {
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes"
    };

    private static String[] WLAN = {
            "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, hotspot",
            "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, hotspot",
            "Wi-Fi 802.11 b/g/n, Wi-Fi Direct, hotspot",
            "Wi-Fi 802.11 b/g/n, Wi-Fi Direct, hotspot",
            "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, hotspot",
            "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, hotspot",
            "Wi-Fi 802.11 b/g/n, Wi-Fi Direct, hotspot",
            "Wi-Fi 802.11 b/g/n, Wi-Fi Direct, hotspot",
            "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, hotspot",
            "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, hotspot",
            "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, hotspot"
    };

    private static String[] Bluetooth = {
            "5.0, A2DP, LE",
            "4.2, A2DP, LE",
            "4.2, A2DP, LE",
            "4.2, A2DP, LE",
            "5.0, A2DP, LE",
            "5.0, A2DP, LE",
            "4.2, A2DP, LE, aptX HD",
            "4.2, A2DP, LE",
            "5.0, A2DP, LE, aptX HD",
            "5.0, A2DP, LE, aptX HD",
            "5.0, A2DP, LE, aptX HD"
    };

    private static String[] Radio = {
            "FM Radio, recording",
            "FM Radio",
            "Wireless FM radio",
            "FM Radio, built-in antenna",
            "FM radio, recording",
            "FM radio, recording",
            "FM radio",
            "FM Radio, built-in antenna",
            "Yes",
            "Yes",
            "Yes"
    };

    private static String[] USB = {
            "2.0, Type-C 1.0 reversible connector",
            "2.0, Type-C 1.0 reversible connector, USB On-The-Go",
            "2.0, Type-C 1.0 reversible connector, USB On-The-Go",
            "2.0, Type-C 1.0 reversible connector, USB On-The-Go",
            "2.0, Type-C 1.0 reversible connector",
            "2.0, Type-C 1.0 reversible connector",
            "microUSB 2.0, USB On-The-Go",
            "microUSB 2.0",
            "2.0, Type-C 1.0 reversible connector, USB On-The-Go",
            "2.0, Type-C 1.0 reversible connector, USB On-The-Go",
            "2.0, Type-C 1.0 reversible connector, USB On-The-Go"
    };

    private static String[] Sensors = {
            "Fingerprint (rear-mounted), accelerometer, gyro, proximity, compass",
            "Fingerprint (rear-mounted), accelerometer, gyro, proximity, compass",
            "Fingerprint (rear-mounted), accelerometer, proximity, compass",
            "Accelerometer, proximity, compass",
            "Fingerprint (rear-mounted), accelerometer, gyro, proximity, compass",
            "Fingerprint (rear-mounted), accelerometer, gyro, proximity, compass",
            "Fingerprint (rear-mounted), accelerometer, proximity, compass",
            "Accelerometer, proximity, compass",
            "Fingerprint (under display, optical), accelerometer, gyro, proximity, compass",
            "Fingerprint (under display, optical), accelerometer, gyro, proximity, compass",
            "Fingerprint (under display, optical), accelerometer, gyro, proximity, compass"
    };

    private static String[] Battery = {
            "Non-removable Li-Po 4500 mAh battery",
            "Non-removable Li-Po 4000 mAh battery",
            "Non-removable Li-Po 5000 mAh battery",
            "Non-removable Li-Po 5000 mAh battery",
            "Non-removable Li-Po 4000 mAh battery",
            "Non-removable Li-Po 4000 mAh battery",
            "Non-removable Li-Po 4000 mAh battery",
            "Non-removable Li-Po 4000 mAh battery",
            "Non-removable Li-Po 4000 mAh battery",
            "Non-removable Li-Po 4000 mAh battery",
            "Non-removable Li-Po 4000 mAh battery"
    };

    private static String[] Price = {
            "$ 205.99",
            "$ 147.69",
            "$ 111.69",
            "$ 96.75",
            "$ 190.89",
            "$ 133.36",
            "$ 106.00",
            "$ 80.99",
            "$ 466.99",
            "$ 327.99",
            "$ 256.99"
    };

    private static int[] foto = {
            R.drawable.redminote8pro,
            R.drawable.redminote8,
            R.drawable.redmi8,
            R.drawable.redmi8a,
            R.drawable.redminote7pro,
            R.drawable.redminote7,
            R.drawable.redmi7,
            R.drawable.redmi7a,
            R.drawable.redmik20propremium,
            R.drawable.redmik20pro,
            R.drawable.redmik20
    };

    public static ArrayList<Hape> getListData() {
        ArrayList<Hape> list = new ArrayList<>();
        for (int i = 0; i < Xiaomi.length; i++) {
            Hape hape = new Hape();
            hape.setId(i);
            hape.setNama(Xiaomi[i]);
            hape.setAnnounced(Announced[i]);
            hape.setStatus(Status[i]);
            hape.setNetwork(Network[i]);
            hape.setDimensions(Dimensions[i]);
            hape.setWeight(Weight[i]);
            hape.setBuild(Build[i]);
            hape.setSim(SIM[i]);
            hape.setType(Type[i]);
            hape.setSize(Size[i]);
            hape.setRes(Resolution[i]);
            hape.setOs(OS[i]);
            hape.setChipset(Chipset[i]);
            hape.setCpu(CPU[i]);
            hape.setGpu(GPU[i]);
            hape.setRam(RAM[i]);
            hape.setInternal(Internal[i]);
            hape.setExternal(External[i]);
            hape.setRearCam(rearCamera[i]);
            hape.setRearFeat(rearFeatures[i]);
            hape.setRearVideo(rearVideo[i]);
            hape.setFrontCam(frontCamera[i]);
            hape.setFrontFeat(frontFeatures[i]);
            hape.setFrontVideo(frontVideo[i]);
            hape.setSpeaker(Speaker[i]);
            hape.setJack(Jack[i]);
            hape.setWlan(WLAN[i]);
            hape.setBluetooth(Bluetooth[i]);
            hape.setRadio(Radio[i]);
            hape.setUsb(USB[i]);
            hape.setSensors(Sensors[i]);
            hape.setBattery(Battery[i]);
            hape.setPrice(Price[i]);
            hape.setFoto(foto[i]);
            list.add(hape);
        }
        return list;
    }
}
