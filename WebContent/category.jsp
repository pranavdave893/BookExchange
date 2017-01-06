<%@page import="com.bookexchange.sell.SellInterface"%>
<%@page import="com.bookexchange.ObjectFactory.ObjectFactory"%>
<%@page import="com.bookexchange.beans.typedetail"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List" %>


<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<head>
 <link href="css/styles2.css" rel="stylesheet" type="text/css">
 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><meta name="keywords" content="Gujarati Dictionary +, iThinkdiff, Education, Reference, ios apps, app, appstore, app store, iphone, ipad, ipod touch, itouch, itunes" /><meta name="description" content="Read reviews, get customer ratings, see screenshots and learn more about Gujarati Dictionary + on the App Store. Download Gujarati Dictionary + and enjoy it on your iPhone, iPad and iPod touch." /><meta name="platform-cache-id" content="8" /><meta content="Gujarati Dictionary +" property="og:title" /><meta content="Get Gujarati Dictionary + on the App Store. See screenshots and ratings, and read customer reviews." property="og:description" /><meta content="App Store" property="og:site_name" /><meta content="http://a3.mzstatic.com/us/r30/Purple4/v4/b9/ae/34/b9ae344e-3c36-85d4-ad8f-54450b8773b0/mzl.zkgeidqp.png" property="og:image" /><meta content="image/png" property="og:image:type" />
 
<title>Book Exchange</title>

 
<script> 
if (!window.its) {
    window.its = {};
}
its.markupLoadStartTime = new Date().getTime();
 
if (!window.onerror) window.onerror = function(message, url, lineNumber) {
    if (!window._earlyOnerrorException) {
        window._earlyOnerrorException = {message: message,
                                         url: url,
                                         lineNumber: lineNumber};
    }
};
</script>
 
 
<link charset="utf-8" rel="stylesheet" type="text/css" href="css/web-storefront-base.css" />
<link charset="utf-8" rel="stylesheet" type="text/css" href="css/web-storefront-preview.css" />
   
<script type="text/javascript" charset="utf-8" src="css/frameworks-primaryinit01.js"></script>

<script type="text/javascript" charset="utf-8">its.serverData={"pageData": {"BUY_PARAM_PRICETYPE": "STDQ","basePrice": 0,"isFree": true,"isCodeEnabledForFree": false,"volumePrice": 0,"basePriceForDisplay": "Free","inflectionValue": 1,"productAdamId": "430520390","productType": "C","BUY_PRODUCT_URL": "https://itunes.apple.com/WebObjects/MZFinance.woa/wa/volumeBuyProduct?cc=in","jsonSearchUrl": "https://itunes.apple.com/in/search","jsonLookupUrl": "https://itunes.apple.com/in/lookup"},"constants": {"Urls": {"upgradeITunesUrl": "http://www.apple.com/itunes/download/","upgradeSafariUrl": "http://www.apple.com/safari/download/"},"MZMediaType": {"Music": {"id": 1},"Podcasts": {"id": 2},"Audiobooks": {"id": 3},"TVShows": {"id": 4},"MusicVideos": {"id": 5},"Movies": {"id": 6},"ClassicSoftware": {"id": 7},"MobileSoftware": {"id": 8},"Ringtones": {"id": 9},"iTunesU": {"id": 10},"EBooks": {"id": 11},"MacSoftware": {"id": 12}},"SFSortOrder": {"Name": {"id": 0},"Featured": {"id": 1},"ReleaseDate": {"id": 2},"Popularity": {"id": 3},"PurchaseDate": {"id": 4},"TopRated": {"id": 5},"ExpirationDate": {"id": 6},"Price": {"id": 7},"ArtistName": {"id": 8},"PlaylistName": {"id": 9},"Duration": {"id": 11},"DiscNumber": {"id": 12},"TrackNumber": {"id": 13},"CmcRecommended": {"id": 10},"AllTimeBestSellers": {"id": 14},"DateAdded": {"id": 15},"MostRecent": {"id": 16},"SeriesOrder": {"id": 17}},"countryCode": "ind","languageCode": "en","SFCustomComponentCountryCode": "ind","IXDisplayableKind": {"Song": {"id": 1,"cssClasses": ["song","music"],"name": "song","mtId": "1"},"Album": {"id": 2,"cssClasses": ["album","music"],"name": "album","mtId": "1"},"Book": {"id": 3,"cssClasses": ["audiobook"],"name": "book","mtId": "3"},"Podcast": {"id": 4,"cssClasses": ["podcast"],"name": "podcast","mtId": "2"},"MusicVideo": {"id": 5,"cssClasses": ["music-video","music","video"],"name": "musicVideo","mtId": "5"},"TVEpisode": {"id": 6,"cssClasses": ["tv-episode","tv","video"],"name": "tvEpisode","mtId": "4"},"TVSeason": {"id": 7,"cssClasses": ["tv-season","tv","video"],"name": "tvSeason","mtId": "4"},"ShortFilm": {"id": 8,"cssClasses": ["short-film","movie","video"],"name": "shortFilm","mtId": "6"},"Movie": {"id": 9,"cssClasses": ["movie","video"],"name": "movie","mtId": "6"},"ClassicSoftware": {"id": 10,"cssClasses": ["ipod-game"],"name": "ipodGame","mtId": "7"},"MobileSoftware": {"id": 11,"cssClasses": ["application"],"name": "iosSoftware","mtId": "8"},"MacSoftware": {"id": 30,"cssClasses": ["application","mac-application"],"name": "desktopApp","mtId": "12"},"iTunesPass": {"id": 12,"cssClasses": ["itunes-pass","album","music"],"name": "itunesPass","mtId": "1"},"Booklet": {"id": 13,"cssClasses": ["booklet","music"],"name": "booklet","mtId": "1"},"Mix": {"id": 14,"cssClasses": ["mix","music"],"name": "mix","mtId": "1"},"PodcastEpisode": {"id": 15,"cssClasses": ["podcast-episode"],"name": "podcastEpisode","mtId": "2"},"SoftwareAddOn": {"id": 16,"cssClasses": ["software-add-on","application"],"name": "softwareAddOn","mtId": "8"},"iMix": {"id": 17,"cssClasses": ["imix","music"],"name": "iMix","mtId": "1"},"ClassicSoftwarePackage": {"id": 18,"cssClasses": ["ipod-game"],"name": "gamePackage","mtId": "7"},"WeMix": {"id": 19,"cssClasses": ["wemix","music"],"name": "itunesMix","mtId": "1"},"Artist": {"id": 20,"cssClasses": [],"name": "artist"},"Ringtone": {"id": 21,"cssClasses": [],"name": "ringtone","mtId": "9"},"RingtoneAlbum": {"id": 22,"cssClasses": [],"name": "ringtoneAlbum","mtId": "9"},"PreorderAlbum": {"id": 23,"cssClasses": ["album","music"],"name": "preorderAlbum","mtId": "1"},"MovieBundle": {"id": 24,"cssClasses": ["bundle","movie","video"],"name": "movieBundle","mtId": "6"},"EBook": {"id": 25,"cssClasses": ["ebook"],"name": "epubBook","mtId": "11"},"Concert": {"id": 26,"cssClasses": [],"name": "concert","mtId": "1"},"SocialPerson": {"id": 27,"cssClasses": [],"name": "socialPerson"},"SocialArtist": {"id": 28,"cssClasses": [],"name": "socialArtist"},"Tone": {"id": 31,"cssClasses": [],"name": "tone","mtId": "9"},"ToneAlbum": {"id": 32,"cssClasses": [],"name": "toneAlbum","mtId": "9"},"TheyMix": {"id": 33,"cssClasses": [],"name": "thirdPartyMix"},"Course": {"id": 34,"cssClasses": ["course","itunes-u"],"name": "course","mtId": "10"},"MetaEBook": {"id": 35,"cssClasses": ["ebook"],"name": "metaEbook","mtId": "13"},"ApplePubEBook": {"id": 36,"cssClasses": ["ebook"],"name": "ibook","mtId": "11"},"ApplePubTextbook": {"id": 37,"cssClasses": ["ebook"],"name": "ibookTextbook","mtId": "13"}},"getEmailUrl": "https://itunes.apple.com/WebObjects/MZStore.woa/wa/generateEmail?cc=in"},"properties": {"clientStatsLoadTimeGroup": "4002","MZHtmlResourcesUtil.allowDeferJsLoad": true,"countryCodeIso2a": "in","currencyFormat": "Rs #,##0.00;Rs #,##0.00;-Rs #,##0.00","currencySymbol": "$","currencyThousandSeparator": ",","currencyDecimalSeparator": ".","MZFeatureEnabler.isCadillacEnabled": false,"MZFinance.VolumeBuyQuantityUpperLimit": 25000,"iTunesUEnrollLink": "","ITSServerEnvironment": "prod","ITSServerInstance": "1001605","ITSResourceRevNum": "987E","resourceUrlPrefix": "https://s.mzstatic.com","ITSLogger.ServerReportingProtocol": "https","ITSLogger.ServerReportingDomain": "metrics.mzstatic.com","ITSLogger.ServerReportingApp": "MZUserXP","ITSLogger.RecordStatsAction": "recordStats","ITSLogger.SenderName": "ITSClient","DynaLoader.allowDynaLoading": true,"itsLoggerQueueProcessingInterval": 10000,"cobaltBundleId": "com.apple.itunesu","getCobaltAppLink": "https://itunes.apple.com/in/app/id490217893","cobaltLearnMore": "https://itunes.apple.com/in/learn-more?about=iTunesUUpgradePage&type=2","isCobaltEnabled": true,"isCobaltJavascriptRedirectEnabled": true,"isCobaltUpsellPageEnabled": true,"personalizedButtonsEnabled": true,"SF6.Personalization.isCMAEnabled": true,"SF6.Personalization.isCMSEnabled": false,"SF6.StorePlatform.whitelistParams": ["caller","dsid","id","p"],"vendLastSupportedVersionIfAvailable": true,"vendLastSupportedVersionMacOs": true,"isBookGiftingEnabled": true,"metrics": {"metricsUrl": "https://xp.apple.com/report","compoundSeparator": "_","tokenSeparator": "|","postFrequency": 60000,"disabled": false,"sendDisabled": false,"blacklistedEvents": ["impressions"],"fieldsMap": {"single": {"targetId": ["id","adamId","type","fcId","station-hash"]},"multi": {},"custom": {"impressions": ["id","adamId","station-hash"],"location": ["id","adamId","dataSetId","name","fcKind","kindIds","type","station-hash","core-seed-name"]}},"metricsBase": {"storeFrontHeader": "","language": "2","platformId": "8","platformName": "ItunesPreview","storeFront": "143467","environmentDataCenter": "NWK"}}}}</script>
<script type="text/javascript" charset="utf-8"> 
if (!window.iTSLocalization) { iTSLocalization = {}; }
iTSLocalization._strings = {"_decimalSeparator":".", "_thousandsSeparator":",", "Js.iTunesStoreError.Message":"We could not complete your request.", "Js.iTunesStoreError.Explanation":"There was an error in the iTunes Store. Please try again later. (@@errorNum@@)", "Js.TextTruncation.More":"More", "More":"More", "Less":"Less", "Js.TextLimit.Remaining":"@@count@@ characters remaining", "Js.Showcase.Next":"Next Item", "Js.InlineReview.1":"hate it", "Js.InlineReview.2":"don\u2019t like it", "Js.InlineReview.3":"it\u2019s ok", "Js.InlineReview.4":"it\u2019s good", "Js.InlineReview.5":"it\u2019s great", "Js.CreateAccount":"Create Apple ID", "Js.InlineReview.SigninTitle":"Sign in to write a review.", "Js.InlineReview.SigninMessage":"Enter your Apple ID and password, then click Sign In.", "Js.InlineRating.SigninTitle":"Sign in to rate this item.", "Js.InlineRating.SigninMessage":"Sign in to continue.", "Js.ReportAConcern.SigninTitle":"Sign in to report a concern.", "Js.ReportAConcern.SigninMessage":"Enter your Apple ID and password, then click Sign In.", "Js.TellAFriend.SigninTitle":"Sign in to tell a friend.", "Js.TellAFriend.SigninMessage":"Enter your Apple ID and password, then click Sign In.", "Js.InlineReview.RateThis":"Rate this", "Js.InlineReview.ClickToRate":"Click to rate", "Js.InlineReview.Thanks":"Thanks!", "Js.InlineReview.Error":"Error", "Js.Pagination.PageNumber":"Page @@num@@", "Js.Pagination.PageNumberTitle":"page @@num@@", "Js.Pagination.PreviousPage":"Previous Page", "Js.Pagination.NextPage":"Next Page", "Js.Pagination.Next":"Next", "Js.Pagination.Back":"Back", "Js.Pagination.DisabledButtonText":"disabled @@button_text@@", "Js.QuickView.Unavailable.Title":"Quick View is currently unavailable for this item.", "Js.QuickView.Unavailable.Text":"Please try again later.", "Js.Search.HintsTitle":"Suggestions", "Js.Wishlist.RemoveTooltip":"Remove from Wish list", "Js.MyAlerts.ConfirmEmailSignUp.Message":"Are you sure you want to receive email alerts?", "Js.MyAlerts.ConfirmEmailSignUp.Explanation":"You can change this preference at any time from your My Alerts page.", "Js.MyAlerts.CancelEmailSignUp.Message":"Are you sure you want to stop receiving email alerts?", "Js.MyAlerts.CancelEmailSignUp.Explanation":"You can change this preference at any time from your My Alerts page.", "Js.MyAlerts.GeniusActivationNeeded.Message":"This requires Genius.", "Js.MyAlerts.GeniusActivationNeeded.Explanation":"Alerts based on your library content will not be enabled until you have turned on Genius. To learn more, click Go to Genius.", "Js.MyAlerts.GeniusActivationNeeded.Button":"Go to Genius", "Js.ManageArtistAlerts.UncheckAll.Artists":"Uncheck All Artists", "Js.ManageArtistAlerts.UncheckAll.Actors":"Uncheck All Actors", "Js.ManageArtistAlerts.UncheckAll":"Uncheck All", "Js.ManageArtistAlerts.CheckAll.Artists":"Check All Artists", "Js.ManageArtistAlerts.CheckAll.Actors":"Check All Actors", "Js.ManageArtistAlerts.CheckAll":"Check All", "Js.List.Item":"item", "Js.InlinePreview.PlayPreview":"Play preview of @@title@@", "Js.InlinePreview.StopPreview":"Stop preview of @@title@@", "Js.CNConnections.UserReview.YouLiked":"You Liked", "Js.CNConnections.PeoplePopupMore":"and @@count@@ other@@s@@...", "Js.CNConnections.Confirmed":"Confirmed", "Js.CNConnections.RequestSent":"Request sent", "Js.CNConnections.LoginRequired.Title":"Sign in to access Ping.", 
"Js.CNConnections.LoginRequired.Message":"This requires Ping. Ping will no longer be available as of September 30, and we are not accepting new members. If you are already a Ping member, sign in below to continue.", "Js.CNConnections.OptInRequired.Title":"Ping", 
"Js.CNConnections.OptInRequired.Message":"This requires Ping. Ping will no longer be available as of September 30, and we are not accepting new members. If you are already a Ping member, sign in below to continue.", "Js.CNConnections.Dialog.Cancel":"Cancel", "Js.CNConnections.Dialog.GetStarted":"Get Started", "CNConnections.Dialog.PrivateUser.IllegalAction.Title":"Private users may not perform this action.", "CNConnections.Dialog.PrivateUser.IllegalAction.Message":"If you would like to perform this action, please change your privacy settings.", "CNConnections.Dialog.PrivateUser.LeakyAction.Title":"Are you sure you want to perform this action?", "CNConnections.Dialog.PrivateUser.LeakyAction.Message":"This action will make your profile picture and name visible to others.", "CNConnections.Dialog.StopFollowing.Title":"Are you sure you want to stop following @@fullName@@?", "CNConnections.Dialog.StopFollowing.Message":"CNConnections.Dialog.StopFollowing.Message", "CNConnections.Dialog.Like.Review.SignIn.Title":"Sign in to like a review.", "CNConnections.Dialog.Like.Review.SignIn.Message":"Enter your Apple ID or AOL screen name and your password, then click Sign In.", "CNConnections.Dialog.Post.Review.SignIn.Title":"Sign in to post.", "CNConnections.Dialog.Post.Review.SignIn.Message":"Enter your Apple ID or AOL screen name and your password, then click Sign In.", "CNConnections.Dialog.OptIn.Title":"Ping Will No Longer Be Available as of September 30", "CNConnections.Dialog.OptIn.Message":"Liking a review requires Ping, and we are no longer accepting new members.", "CNConnections.Dialog.OptIn.ButtonSubmit":"Learn More", "CNConnections.Dialog.OptIn.ButtonCancel":"Cancel", "CNConnections.Dialog.OptIn.ButtonSignIn":"Sign In", "CNConnections.Upload.UploadErrorHeading":"There Is a Problem With Your Upload", "CNConnections.Upload.UploadErrorMessage":"Sorry, there was an error during upload.", "CNConnections.Upload.MaxPhotosErrorMessage":"You can have no more than 20 photos in one post.", "JS.errors.requiredLite":"Please fill in all required fields."}
</script>
 
<script type="text/javascript" charset="utf-8" src="css/web-storefront-base.js"></script>
<script type="text/javascript" charset="utf-8" src="css/web-storefront-preview.js"></script>
 
 
<link charset="utf-8" href="css/navigation.css" id="globalheader-stylesheet" rel="stylesheet" type="text/css" />

<style type="text/css">
<!--
.style1 {color: #FFFFFF}
.style2 {color:#0066FF}
-->
</style>

<body>


<div id="left-stack" class="font">

             <div  id='categorymenu'>
             
              <ul>
			  
			   <%
			  	SellInterface objSell=ObjectFactory.getInstance().getSellInterface();
			   List<typedetail> objList=objSell.setBookView("getcategory",5,0);
			  	
			    for(Iterator<typedetail> i= objList.iterator(); i.hasNext();)
				 
			    {
			    	typedetail td=(typedetail)i.next();
			    	int id=td.getTypeid();
			    %>
			    	
			    		<li class="style2"><b ><%=td.getTypename()%></b></li> 
			  			
                          <%
		                      List<typedetail> objList1=objSell.setBookView("getcategory",5,id);
		                      for(Iterator<typedetail> i1= objList1.iterator(); i1.hasNext();)
		          	   	   	 {
		          		    	typedetail td1=(typedetail)i1.next();
		          		    	int id1=td1.getTypeid();
		          			    	
		                        %>
		                       
		                        	<li class='has-sub'><a href="#"><%=td1.getTypename()%></a>
		                    			
		                        		
		                         <%
		                         
		                         List<typedetail> objList2=objSell.setBookView("getcategory",5,id1);
		                         if(objList2.size() > 0){%>
		                         <ul>
		                         <%}
			                      for(Iterator<typedetail> i2= objList2.iterator(); i2.hasNext();)
			          	   	   	 {
			          		    	typedetail td2=(typedetail)i2.next();
			          		    	
			                        %>
			                        <li class='last'><a href="#"><%=td2.getTypename()%></a></li>
			                       
			                         <%
			          	   	   	 } 
			                      if(objList2.size() > 0){%>
			                        </ul>
			                         <%}
			          	   	   	 %>
			          	   	   	 
			                      
			                      </li>
			                       <%
				   				 }
		                      
			    }
                         		%>
				
              </ul>
        </div>
         </div>
   

 
</body>
</html>
