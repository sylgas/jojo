package pl.lusy.jojo.journeyjournal.data.model

import pl.lusy.jojo.journeyjournal.data.entity.DatabaseEntity

data class Plan(val steps: List<PlanStep>) : DatabaseEntity
