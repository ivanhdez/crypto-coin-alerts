package com.alexitc.coinalerts.models

import com.alexitc.coinalerts.core.{WrappedInt, WrappedString}
import play.api.libs.json.{JsPath, Reads}

/**
 * [[ExchangeCurrency]] represents a currency that can be traded in
 * the [[Market]] supported by the [[Exchange]].
 *
 * For example, I could go to BITTREX (exchange) to buy BTC (market)
 * paying with LTC (currency).
 */
case class ExchangeCurrency(
    id: ExchangeCurrencyId,
    exchange: Exchange,
    market: Market,
    currency: Currency)

case class ExchangeCurrencyId(int: Int) extends AnyVal with WrappedInt
object ExchangeCurrencyId {
  implicit val reads: Reads[ExchangeCurrencyId] = {
    JsPath.read[Int].map(ExchangeCurrencyId.apply)
  }
}

case class Market(string: String) extends AnyVal with WrappedString
case class Currency(string: String) extends AnyVal with WrappedString
