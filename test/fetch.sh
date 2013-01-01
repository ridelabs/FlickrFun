#url="http://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=3559b1c0d10be7fd9ff0e38d326a92bd&text=snowboarding&per_page=10&format=json&nojsoncallback=1&api_sig=8c0e217b938790070f89baa36ea6d9ab"
term="utah+arts+festival"
url="http://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=3559b1c0d10be7fd9ff0e38d326a92bd&text=$term&per_page=10&format=json&nojsoncallback=1"

format="http://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg"

curl $url


