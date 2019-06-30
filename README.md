# ze-appp
Droidcon Berlin Google Developper Group Community App : Write one app together, with 15 minutes each

## Write what you want

Addd a nyan cat, add a calendar, do something crazy! This app is your ouister...

## Write an app displaying Android conferences

We have prepared an restAPI based on http://androidstudygroup.github.io/conferences/ using https://wrapapi.com:

```
curl -X POST -d 'wrapAPIKey=7UF1tvyFxs4TXQDYq4btuIIfIuHvbSdz' https://wrapapi.com/use/mariobodemann/conferences/android/latest
```

resulting in:

```
[ {
    "name": "Droidcon",
    "place": "Berlin, Germany",
    "date": "2019-07-01",
    "cfp": {
      "from": "2018-10-29",
      "to": "2019-04-30",
      "url": "https://sessionize.com/droidcon-berlin-2019/"
    },
    "link": "https://www.de.droidcon.com/"
  },...
]
```
