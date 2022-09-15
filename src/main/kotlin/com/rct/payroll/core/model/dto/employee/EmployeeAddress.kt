package com.rct.payroll.core.model.dto.employee

import com.rct.payroll.core.model.dto.address.City
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.UUID
import java.util.UUID.randomUUID

/**
 * Address employee DTO
 *
 * @property id UUID
 * @property streetType StreetType Enumerator
 * @property street
 * @property number Number
 * @property city City
 * @property zipCode String
 * @property employeeId UUID
 * @property active Boolean
 * @property createdAt LocalDateTime
 * @property updatedAt LocalDateTime
 * @constructor Create empty Address employee
 */
data class EmployeeAddress(
    val id: UUID = randomUUID(),
    val streetType: StreetType,
    var street: String,
    var number: Number,
    val city: City,
    var zipCode: String,
    val employeeId: UUID,
    var active: Boolean = true,
    val createdAt: LocalDateTime = now(),
    var updatedAt: LocalDateTime,
)

/**
 * Street type - Enumerator
 *
 * @property description
 * @constructor Create empty Street type
 */
enum class StreetType(
    val description: String,
) {
    AIRPORT(description = "Airport"),
    ALLEY(description = "Alley"),
    ALLOTMENT(description = "Allotment"),
    AREA(description = "Area"),
    AVENUE(description = "Avenue"),
    BLOCK(description = "Block"),
    CATWALK(description = "Catwalk"),
    CLOVER(description = "Clover"),
    CONDOMINIUM(description = "Condominium"),
    COLOGNE(description = "Cologne"),
    CORE(description = "Core"),
    COURTYARD(description = "Courtyard"),
    DISTRICT(description = "District"),
    ESPLANADE(description = "Esplanade"),
    FAIR(description = "Fair"),
    FARM(description = "Farm"),
    FIELD(description = "Field"),
    GARDEN(description = "Garden"),
    HIGHWAY(description = "Highway"),
    HILL(description = "Hill"),
    LAGOON(description = "Lagoon"),
    LAKE(description = "Lake"),
    NOOK(description = "Nook"),
    PARK(description = "Park"),
    PATH(description = "Path"),
    PLACE(description = "Place"),
    PLATTER(description = "Platter"),
    RESIDENTIAL(description = "Residential"),
    ROAD(description = "Road"),
    SEASON(description = "Season"),
    SECTOR(description = "Sector"),
    SET(description = "Set"),
    SHANTYTOWN(description = "Shantytown"),
    SLOPE(description = "Slope"),
    SQUARE(description = "Square"),
    STRETCH(description = "Stretch"),
    VALLEY(description = "Valley"),
    VIA(description = "Via"),
    VIADUCT(description = "Viaduct"),
    VILLAGE(description = "Village"),
    WIDE(description = "Wide"),
}
