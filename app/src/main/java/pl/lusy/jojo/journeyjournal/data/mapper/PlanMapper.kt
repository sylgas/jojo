package pl.lusy.jojo.journeyjournal.data.mapper

import pl.lusy.jojo.journeyjournal.data.db.entity.PlanStepEntity
import pl.lusy.jojo.journeyjournal.data.db.entity.PlanSteps
import pl.lusy.jojo.journeyjournal.data.model.Plan
import pl.lusy.jojo.journeyjournal.data.model.PlanStep

fun PlanSteps.toPlan() = Plan(planSteps.toPlanSteps())

fun List<PlanStepEntity>.toPlanSteps() = this.map { it.toPlanStep() }

fun PlanStepEntity.toPlanStep() = PlanStep(title, description)