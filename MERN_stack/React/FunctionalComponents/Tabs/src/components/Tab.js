import React, {useState} from 'react'


const Tab = (props) => {
  const [active, setActive] = useState("Tab1");
  const [content, setContent] = useState(props.tabData[1].content);

  const onClickFun = (event, tab) => {
    setActive(tab.name);
    setContent(tab.content);
  };

  return (
    <>
      <div className="row  my-5">
        <div className="col-6 offset-3">
          <ul className="nav nav-pills">
            {props.tabData.map((tab, i) => {
              return (
                <li key={i} className="nav-item">
                  <button
                    onClick={(event) => onClickFun(event, tab)}
                    className={
                      "me-3 " +
                      (active === tab.name
                        ? "active btn btn-dark "
                        : "btn btn-outline-dark")
                    }
                    type="button"
                  >
                    {tab.name}
                  </button>
                </li>
              );
            })}
          </ul>
          <div className="text-start border border-1 border-dark p-4 mt-4">
            {content}
          </div>
        </div>
      </div>
    </>
  )
}

export default Tab