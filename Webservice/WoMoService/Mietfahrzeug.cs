//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace WoMoService
{
    using System;
    using System.Collections.Generic;
    
    public partial class Mietfahrzeug
    {
        public int fahrgestellNr { get; set; }
        public int idSaison { get; set; }
        public int idKunde { get; set; }
        public Nullable<System.DateTime> datumVon { get; set; }
        public Nullable<System.DateTime> datumBis { get; set; }
    
        public virtual Fahrzeug Fahrzeug { get; set; }
        public virtual Kunde Kunde { get; set; }
        public virtual Saison Saison { get; set; }
    }
}
