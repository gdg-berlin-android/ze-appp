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


# Results

💥This is what we did at the #DCBerlin19💥
* Gource: https://youtu.be/QozFNLnny8o
* Run through: https://youtu.be/vXr5eXEDQb8
* Source: https://github.com/gdg-berlin-android/ze-appp ….

Next: meet us at our next meetup https://www.meetup.com/berlindroid/events/ktlzcryzkbpc/ … we are sure that someone™ will talk about it.
