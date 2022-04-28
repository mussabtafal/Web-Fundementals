import React from 'react'
import { Link } from 'react-router-dom'

const Header = () => {
    return (
        <div>
            <Link to='/players'>
                Managae Players
            </Link>
            |
            <Link to='/status/game1'>
                Managae Player Status
            </Link>
        </div>
    )
}

export default Header