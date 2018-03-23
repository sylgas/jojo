package pl.lusy.jojo.journeyjournal.data.mapper

import pl.lusy.jojo.journeyjournal.data.entity.PlanEntity
import pl.lusy.jojo.journeyjournal.data.entity.PlanStepEntity
import pl.lusy.jojo.journeyjournal.data.model.Plan
import pl.lusy.jojo.journeyjournal.data.model.PlanStep

fun PlanEntity.toPlan() = Plan(steps.toPlanSteps())

fun List<PlanStepEntity>.toPlanSteps() = this.map { it.toPlanStep() }

fun PlanStepEntity.toPlanStep() = PlanStep(title, description)