package com.rrtx.util;

public class ConversionUtil {

    /**
     * 将国家的三位字母代码转换为字母
     * 默认为: 马来西亚    Malaysia    MY 	MYS 	458
     * @param threeCountryLetter
     * @return
     */
    public static String threeCountryNumToLetter(String threeCountryLetter) {
        switch (threeCountryLetter) {
            case"AND":return"20";case"ARE":return"784";case"AFG":return"4";case"ATG":return"28";case"AIA":return"660";case"ALB":return"8";case"ARM":return"51";case"AGO":return"24";case"ATA":return"10";case"ARG":return"32";case"ASM":return"16";case"AUT":return"40";case"AUS":return"36";case"ABW":return"533";case"ALA":return"248";case"AZE":return"31";case"BIH":return"70";case"BRB":return"52";case"BGD":return"50";case"BEL":return"56";case"BFA":return"854";case"BGR":return"100";case"BHR":return"48";case"BDI":return"108";case"BEN":return"204";case"BLM":return"652";case"BMU":return"60";case"BRN":return"96";case"BOL":return"68";case"BES":return"535";case"BRA":return"76";case"BHS":return"44";case"BTN":return"64";case"BVT":return"74";case"BWA":return"72";case"BLR":return"112";case"BLZ":return"84";case"CAN":return"124";case"CCK":return"166";case"CAF":return"140";case"CHE":return"756";case"CHL":return"152";case"CMR":return"120";case"COL":return"170";case"CRI":return"188";case"CUB":return"192";case"CPV":return"132";case"CXR":return"162";case"CYP":return"196";case"CZE":return"203";case"DEU":return"276";case"DJI":return"262";case"DNK":return"208";case"DMA":return"212";case"DOM":return"214";case"DZA":return"12";case"ECU":return"218";case"EST":return"233";case"EGY":return"818";case"ESH":return"732";case"ERI":return"232";case"ESP":return"724";case"FIN":return"246";case"FJI":return"242";case"FLK":return"238";case"FSM":return"583";case"FRO":return"234";case"FRA":return"250";case"GAB":return"266";case"GRD":return"308";case"GEO":return"268";case"GUF":return"254";case"GHA":return"288";case"GIB":return"292";case"GRL":return"304";case"GIN":return"324";case"GLP":return"312";case"GNQ":return"226";case"GRC":return"300";case"SGS":return"239";case"GTM":return"320";case"GUM":return"316";case"GNB":return"624";case"GUY":return"328";case"HKG":return"344";case"HMD":return"334";case"HND":return"340";case"HRV":return"191";case"HTI":return"332";case"HUN":return"348";case"IDN":return"360";case"IRL":return"372";case"ISR":return"376";case"IMN":return"833";case"IND":return"356";case"IOT":return"86";case"IRQ":return"368";case"IRN":return"364";case"ISL":return"352";case"ITA":return"380";case"JEY":return"832";case"JAM":return"388";case"JOR":return"400";case"JPN":return"392";case"KHM":return"116";case"KIR":return"296";case"COM":return"174";case"KWT":return"414";case"CYM":return"136";case"LBN":return"422";case"LIE":return"438";case"LKA":return"144";case"LBR":return"430";case"LSO":return"426";case"LTU":return"440";case"LUX":return"442";case"LVA":return"428";case"LBY":return"434";case"MAR":return"504";case"MCO":return"492";case"MDA":return"498";case"MNE":return"499";case"MAF":return"663";case"MDG":return"450";case"MHL":return"584";case"MKD":return"807";case"MLI":return"466";case"MMR":return"104";case"MAC":return"446";case"MTQ":return"474";case"MRT":return"478";case"MSR":return"500";case"MLT":return"470";case"MDV":return"462";case"MWI":return"454";case"MEX":return"484";case"MYS":return"458";case"NAM":return"516";case"NER":return"562";case"NFK":return"574";case"NGA":return"566";case"NIC":return"558";case"NLD":return"528";case"NOR":return"578";case"NPL":return"524";case"NRU":return"520";case"OMN":return"512";case"PAN":return"591";case"PER":return"604";case"PYF":return"258";case"PNG":return"598";case"PHL":return"608";case"PAK":return"586";case"POL":return"616";case"PCN":return"612";case"PRI":return"630";case"PSE":return"275";case"PLW":return"585";case"PRY":return"600";case"QAT":return"634";case"REU":return"638";case"ROU":return"642";case"SRB":return"688";case"RUS":return"643";case"RWA":return"646";case"SLB":return"90";case"SYC":return"690";case"SDN":return"729";case"SWE":return"752";case"SGP":return"702";case"SVN":return"705";case"SJM":return"744";case"SVK":return"703";case"SLE":return"694";case"SMR":return"674";case"SEN":return"686";case"SOM":return"706";case"SUR":return"740";case"SSD":return"728";case"STP":return"678";case"SLV":return"222";case"SYR":return"760";case"SWZ":return"748";case"TCA":return"796";case"TCD":return"148";case"TGO":return"768";case"THA":return"764";case"TKL":return"772";case"TLS":return"626";case"TUN":return"788";case"TON":return"776";case"TUR":return"792";case"TUV":return"798";case"TZA":return"834";case"UKR":return"804";case"UGA":return"800";case"USA":return"840";case"URY":return"858";case"VAT":return"336";case"VEN":return"862";case"VGB":return"92";case"VIR":return"850";case"VNM":return"704";case"WLF":return"876";case"WSM":return"882";case"YEM":return"887";case"MYT":return"175";case"ZAF":return"710";case"ZMB":return"894";case"ZWE":return"716";case"CHN":return"156";case"COG":return"178";case"COD":return"180";case"MOZ":return"508";case"GGY":return"831";case"GMB":return"270";case"MNP":return"580";case"ETH":return"231";case"NCL":return"540";case"VUT":return"548";case"ATF":return"260";case"NIU":return"570";case"UMI":return"581";case"COK":return"184";case"GBR":return"826";case"TTO":return"780";case"VCT":return"670";case"TWN":return"158";case"NZL":return"554";case"SAU":return"682";case"LAO":return"418";case"PRK":return"408";case"KOR":return"410";case"PRT":return"620";case"KGZ":return"417";case"KAZ":return"398";case"TJK":return"762";case"TKM":return"795";case"UZB":return"860";case"KNA":return"659";case"SPM":return"666";case"SHN":return"654";case"LCA":return"662";case"MUS":return"480";case"CIV":return"384";case"KEN":return"404";case"MNG":return"496";
            default:return"458";
        }
    }

    /**
     * 通过msgType获取url后缀
     * @param msgType
     * @return
     */
    public static String msgTypeToUrlSuffix(String msgType) {
        switch(msgType){
            case "CVM_INQUIRY" :
                return "/scis/switch/cvminquiry";
            case "KYC_VERIFICATION" :
                return "/scis/switch/kycverify";
            case "OPEN_ACCOUNT" :
                return "/scis/switch/openaccount";
            case "CARD_ENROLLMENT" :
                return "/scis/switch/cardenrollment";
            case "CARDFACE_DOWNLOADING" :
                return "/scis/switch/cardfacedownloading";
            case "ACCOUNT_UPDATE_NOTIFICATION" :
                return "/scis/switch/account_update_notification";
            case "CARD_STATUS_MANAGEMENT" :
                return "/scis/switch/cardstatusmgt";
            case "CARD_STATUS_INQUIRY" :
                return "/scis/switch/cardstatusinquiry";
            case "CARD_BALANCE_INQUIRY" :
                return "/scis/switch/cardbalanceinquiry";
            case "EXCHANGE_RATE_INQUIRY" :
                return "/scis/switch/exchangerateinquiry";
            case "P2P_TRANSFER" :
                return "/scis/switch/p2ptransfer";
            case "QRC_GENERATION" :
                return "/scis/switch/qrcgeneration";
            case "ADDITIONAL_PROCESSING_RESULT" :
                return "/scis/switch/additionalprocessingresult";
            case "GET_CASH_OUT_TOKEN" :
                return "/scis/switch/cashouttoken";
            case "QRC_INFO_INQUIRY" :
                return "/scis/switch/qrcinfoinquiry";
            case "MPQRC_PAYMENT_EMV" :
                return "/scis/switch/qremvpayment";
            case "MPQRC_PAYMENT_URL" :
                return "/scis/switch/qrurlpayment";
            case "BILL_PAYMENT" :
                return "/scis/switch/billpayment";
            case "CREDIT_TRANSACTION" :
                return "/scis/switch/credittransaction";
            case "TRX_RESULT_INQUIRY" :
                return "/scis/switch/trxresultinquiry";
            case "KEY_EXCHANGE" :
                return "/uags/api/v1/exchange";
            default:
                return "";
        }
    }

}
