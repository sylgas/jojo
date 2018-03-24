package pl.lusy.jojo.journeyjournal.view.main.adapter.item

sealed class HomeItem(val title: String, val description: String)

class TripHomeItem : HomeItem("Current trip", "Trip description")

class PlanHomeItem : HomeItem("Today's plan", "Plan details")

class LocationHomeItem : HomeItem("Location info", "Explore")